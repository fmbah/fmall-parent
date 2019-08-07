package com.fmbah.fmall.bootorderconsumerservice.api;

import com.fmbah.fmall.bean.HkCrad;
import com.fmbah.fmall.bootorderconsumerservice.service.OrderService;
import com.fmbah.fmall.service.HkCardService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TestController {

    @Autowired
    OrderService orderService;
    @Reference(version = "1.0.0")
    HkCardService hkCardService;


    @RequestMapping("initOrder")
    public Object initOrder(@RequestParam("userId") String userId) throws IOException {



        for (int i = 0; i< Integer.MAX_VALUE; i++) {

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://hk.51240.com/web_system/51240_com_www/system/file/hk/g/?&ajaxtimestamp=1564381680018")
                    .build();

            try (Response response = client.newCall(request).execute()) {
                Document document = Jsoup.parse(response.body().string());
                Element tbody = document.getElementsByClass("kuang_biaoge").select("table").select("tbody").get(1);
                Elements trs = tbody.select("tr");


                int tr_js = 0;
                for (Element tr : trs) {

                    if (tr_js++ == 0) {
                        continue;
                    }

                    HkCrad hkCrad = new HkCrad();
                    Elements tds = tr.select("td");
                    int js = 0;
                    for (Element td : tds) {
                        if (js == 0) {
                            hkCrad.setName(td.html());
                        }
                        if (js == 1) {
                            hkCrad.setCardNum(td.html());
                        }
                        if (js == 2) {
                            hkCrad.setType(td.html());
                        }
                        js++;
                    }
                    hkCardService.insertHkCard(hkCrad);
                }

            }


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



            HkCrad hkCrad = new HkCrad();
            hkCrad.setName("测试名称" + i);
            hkCrad.setCardNum(System.currentTimeMillis() + StringUtils.EMPTY);
            hkCrad.setType("身份证类型......" + i);
            hkCardService.insertHkCard(hkCrad);
        }



        return orderService.initOrder(userId);
    }



}
