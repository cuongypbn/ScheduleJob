package vn.cmctelecom.scheduler.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.grpc.Channel;
import okhttp3.*;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.*;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import vn.cmctelecom.scheduler.enitiy.ParameterJob;
import vn.cmctelecom.scheduler.enitiy.SchedulerJobInfo;
import vn.cmctelecom.scheduler.enitiy.response.ResponseData;
import vn.cmctelecom.scheduler.mailDetect.MailInfo;
import vn.cmctelecom.scheduler.mailDetect.MailReply;
import vn.cmctelecom.scheduler.mailDetect.MailRequest;
import vn.cmctelecom.scheduler.mailDetect.MailServiceGrpc;
import vn.cmctelecom.scheduler.repository.SchedulerJobInfoRepository;
import vn.cmctelecom.scheduler.service.ExternalService;
import vn.cmctelecom.scheduler.util.Result;

import java.io.IOException;
import java.util.Locale;
import java.util.logging.Logger;


public class ExternalMailServiceImpl implements ExternalService {
    private static final Logger logger = Logger.getLogger(ExternalMailServiceImpl.class.getName());


    private final SchedulerJobInfoRepository schedulerJobInfoRepository;

    private final MailServiceGrpc.MailServiceBlockingStub blockingStub;

    public ExternalMailServiceImpl(SchedulerJobInfoRepository schedulerJobInfoRepository, Channel channel) {
        this.schedulerJobInfoRepository = schedulerJobInfoRepository;
        this.blockingStub = MailServiceGrpc.newBlockingStub(channel);
    }

    @Override
    public ResponseEntity<ResponseData> restfulApi(SchedulerJobInfo jobInfo) {
        Response response = null;
        OkHttpClient client = new OkHttpClient();
        try {
            RestTemplate restTemplate = new RestTemplate();
            FormBody.Builder bodyBuilder = new FormBody.Builder();
            HttpUrl.Builder builder = null;
//                    new HttpUrl.Builder().scheme("http").host(jobInfo.getJobHost()).port(8082).addPathSegment(jobInfo.getJobPath());
            RequestBody body = null;
            Request request = null;
            HttpEntity<String> entity = null;
            if (jobInfo.getParameterJobList() != null) {
                if (jobInfo.getParameterJobList().size() > 0) {
                    for (ParameterJob parameterJob : jobInfo.getParameterJobList()) {
                        if (jobInfo.getMethod().equals("GET")) {
                            builder.addEncodedQueryParameter(parameterJob.getParameterName(), parameterJob.getParameterValue());
                        } else {
                            if (parameterJob.getAppConfig().getValue().toUpperCase(Locale.ROOT).equals("JSON")) {
                                HttpHeaders headers = new HttpHeaders();
                                headers.setContentType(MediaType.APPLICATION_JSON);

                                entity  = new HttpEntity<String>(parameterJob.getParameterValue(),headers);
//                                Gson gson = new Gson();
//                                JSONObject json = new JSONObject();
////                                json=gson.fromJson(parameterJob.getParameterValue(),JSONObject.class);
//                                body = RequestBody.create(json.toString(),MediaType.parse("application/json; charset=utf-8")); // new
////                                System.out.println(body);
                            }
                            bodyBuilder.add(parameterJob.getParameterName(), parameterJob.getParameterValue());
                        }
                    }
                }
            }
            body = bodyBuilder.build();
            if (jobInfo.getMethod().equals(HttpMethod.POST.name())) {
                ResponseEntity<String> answer = restTemplate.exchange("http://"+jobInfo.getJobHost()+jobInfo.getJobPath(),HttpMethod.POST, entity, String.class);
                System.out.println(answer.getBody());
            } else if (jobInfo.getMethod().equals(HttpMethod.PUT.name())) {
                request = new Request.Builder().url(builder.build()).put(body).build();
            } else if (jobInfo.getMethod().equals(HttpMethod.DELETE.name())) {

                request = new Request.Builder().url(builder.build()).put(body).build();
            } else if (jobInfo.getMethod().equals(HttpMethod.GET.name())) {
                HttpUrl httpUrl = builder.build();
                request = new Request.Builder().url(httpUrl).build();
            }
            Call call = client.newCall(request);
            response = call.execute();
            System.out.println(response.body());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return new ResponseEntity<>(new ResponseData(response.body(), Result.SUCCESS), HttpStatus.OK);
    }

    @Override
    public String grpcFunction(SchedulerJobInfo jobInfo) {
        MailReply response = null;
        if (jobInfo.getJobPath().equals("detectMail")) {
            MailInfo.Builder mailInfoBuilder = MailInfo.newBuilder();
//        mailInfoBuilder.setHost("");
            MailRequest mailRequest = MailRequest.newBuilder().setMailInfo(mailInfoBuilder.build()).setTypeScan("").build();
            response = blockingStub.detectMail(mailRequest);
        }


        return response.getMailInfo().toString();
    }

    @Override
    public ResponseEntity<ResponseData> detectMail() {
        return null;
    }


}
