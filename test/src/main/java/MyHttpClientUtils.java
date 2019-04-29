import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author lida
 * @filename: HttpClientUtil
 * @description: http client 帮助类
 * @date 2013年7月25日 下午3:42:30
 */
public class MyHttpClientUtils {


    /**
     * @Title: postHttp @Description: TODO @param socketTimeout :单位：毫秒 @param
     * connectTimeout :单位：毫秒 @return String @throws
     */
    public static String postHttp(String url, Map<String, Object> mapParams, int socketTimeout, int connectTimeout) throws InterruptedException {
        String responseMsg = "";

        CloseableHttpClient httpclient = HttpClients.createDefault();
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();

        if (!(mapParams == null || mapParams.isEmpty())) {
            for (Map.Entry<String, Object> entry : mapParams.entrySet()) {
                String value = entry.getValue() == null ? "" : entry.getValue().toString();
                formparams.add(new BasicNameValuePair(entry.getKey(), value));
            }
        }

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
        HttpPost httppost = new HttpPost(url);
        httppost.setEntity(entity);

        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout)
                .setConnectTimeout(connectTimeout).build(); // 设置请求和传输超时时间
        httppost.setConfig(requestConfig);

        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httppost);
            responseMsg = EntityUtils.toString(response.getEntity(), "UTF-8");
            responseMsg = new String(responseMsg.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseMsg;
    }

}
