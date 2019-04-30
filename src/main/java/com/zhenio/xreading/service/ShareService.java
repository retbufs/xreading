package com.zhenio.xreading.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhenio.xreading.Played;
import com.zhenio.xreading.mapper.SharesMapper;
import com.zhenio.xreading.model.Shares;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareService {
    private SharesMapper sharesMapper;

    @Autowired
    public ShareService(SharesMapper sharesMapper) {
        this.sharesMapper = sharesMapper;
    }

    public void parseJson() throws InterruptedException {
        String jsons = "";
        JSONObject jsonObject = (JSONObject) JSON.parse(jsons.toString());
        JSONArray jsonArray;
        System.out.println("来到了这里");
        if (jsonObject.getJSONObject("data") != null) {
            jsonObject = jsonObject.getJSONObject("data");
            jsonArray = jsonObject.getJSONArray("list");
            List<Shares> shares = jsonArray.toJavaList(Shares.class);
            System.out.println(shares);
            int count = 0;
            for (Shares shares1 : shares) {
                System.out.println("来了");
                if (count % 2 == 0) {
                    Thread.sleep(1000);
                }
                sharesMapper.insert(shares1);
            }
            System.out.println("结束");
        }
        //nAllPage = Y/X+(Y%X?1:0)
        //计算总


    }

    public void page() {

    }
    public Played findAll() {
        List<Shares> all = sharesMapper.findAll();
        if (all.isEmpty()) {
            return Played.isError("系统故障，请稍后重试");
        }
        return Played.isOk(all);
    }
}