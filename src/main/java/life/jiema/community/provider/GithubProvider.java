package life.jiema.community.provider;

import com.alibaba.fastjson.JSON;
import life.jiema.community.dto.AccessTokenDTO;
import life.jiema.community.dto.GitHubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author Zhoujunjie
 * @create 2019/9/24 16:26
 */
@Component
public class GithubProvider {

    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType
                = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String str =  response.body().string();
            String[] split = str.split("&");
            String tokenStr = split[0];
            String token = tokenStr.split("=")[1];
//            System.out.println(token);
            return token;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public GitHubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();


        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();

        try (Response response = client.newCall(request).execute()) {

            String string =  response.body().string();
            GitHubUser gitHubUser = JSON.parseObject(string,GitHubUser.class);
            return gitHubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
