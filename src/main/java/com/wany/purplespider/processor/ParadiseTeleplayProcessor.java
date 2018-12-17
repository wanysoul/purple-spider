package com.wany.purplespider.processor;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.wany.purplespider.bean.ParadiseTeleplay;
import com.wany.purplespider.dao.ParadiseTeleplayDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ParadiseTeleplayProcessor implements PageProcessor {

    private static final String URL_LIST = "https://www.meijutt.com/file/list6_\\w+\\.html";


    MongoOperations mongoOps = new MongoTemplate(new SimpleMongoDbFactory(new MongoClient(), "mydb"));

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {

//        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
//        page.putField("name", page.getHtml().xpath("//div[@class='down_list max-height']/ul/li[2]/text()").toString());
//        System.out.println(page.getHtml().xpath("//div[@class='down_list']/ul/li/p").all());

//        page.getHtml().xpath("//div[@class='down_list']/ul/li/p").all().forEach(str -> {
//            Pattern compile = Pattern.compile("(?<=href\\=\").*?(?=\")");
//            Matcher matcher = compile.matcher(str);
////            System.out.println(matcher.find());
//            while (matcher.find()) {
//                System.out.println(matcher.group());
//            }
//
//        });
//        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));

        page.addTargetRequests(page.getHtml().xpath("//a").links().regex(URL_LIST).all());
        page.addTargetRequests(page.getHtml().xpath("//a[@class='B font_14']").links().all());


//        if (page.getHtml().xpath("//div[@class='info-title']/h1/text()") == null) {
//            System.out.println(page.getHtml().xpath("//div[@class='info-title']/h1/text()").toString());
//            page.setSkip(true);
//        }
        ParadiseTeleplay paradiseTeleplay = this.productionObj(page);
//        System.out.println(page.getHtml().xpath("//div[@class='o_big_img_bg_b']/img/@src").toString());
        System.out.println(paradiseTeleplay);
        if (paradiseTeleplay.getTitle() != null) {
            Query title = Query.query(Criteria.where("title").is(paradiseTeleplay.getTitle()));
//            Update update = Update.update("title", paradiseTeleplay.getTitle());
            Update update = this.productionUpdate(paradiseTeleplay);
//            update.set("name", paradiseTeleplay.getName());
            mongoOps.upsert(title, update, ParadiseTeleplay.class, "cartoon");
//            mongoOps.save(paradiseTeleplay,"anime_cartoon");
//            mongoOps.save(paradiseTeleplay, "metropolis_emotion");

        }

//        teleplayDao.saveParadiseTeleplay(paradiseTeleplay);

    }

    @Override
    public Site getSite() {
        return site;
    }

    public void capture() {
        Spider.create(new ParadiseTeleplayProcessor())
                //从"https://github.com/code4craft"开始抓
                .addUrl("https://www.meijutt.com/file/list6.html")
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
    }

    public void capture(String path) {
        Spider.create(new ParadiseTeleplayProcessor())
                //从"https://github.com/code4craft"开始抓
                .addUrl("https://www.meijutt.com/content/" + path + ".html")
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
    }

    public void capture(String path, ParadiseTeleplayDao teleplayDao) {
        Spider.create(new ParadiseTeleplayProcessor())
                //从"https://github.com/code4craft"开始抓
                .addUrl("https://www.meijutt.com/content/" + path + ".html")
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
    }

    private Update productionUpdate(ParadiseTeleplay paradiseTeleplay) {
        Update update = new Update();
        update.set("title", paradiseTeleplay.getTitle());
        update.set("name", paradiseTeleplay.getName());
        update.set("alias", paradiseTeleplay.getAlias());
        update.set("scriptwriter", paradiseTeleplay.getScriptwriter());
        update.set("director", paradiseTeleplay.getDirector());
        update.set("protagonist", paradiseTeleplay.getProtagonist());
        update.set("premiereDate", paradiseTeleplay.getPremiereDate());
        update.set("translate", paradiseTeleplay.getTranslate());
        update.set("subClassification", paradiseTeleplay.getSubClassification());
        update.set("region", paradiseTeleplay.getRegion());
        update.set("televisionStation", paradiseTeleplay.getTelevisionStation());
        update.set("date", paradiseTeleplay.getDate());
        update.set("runningTime", paradiseTeleplay.getRunningTime());
        update.set("type", paradiseTeleplay.getType());
        update.set("runningTime", paradiseTeleplay.getRunningTime());
        update.set("nextSeason", paradiseTeleplay.getNextSeason());
        update.set("poster", paradiseTeleplay.getPoster());
        return update;
    }

    private ParadiseTeleplay productionObj(Page page) {
        ParadiseTeleplay paradiseTeleplay = new ParadiseTeleplay();
        paradiseTeleplay.setTitle(page.getHtml().xpath("//div[@class='info-title']/h1/text()").toString());
        paradiseTeleplay.setName(page.getHtml().xpath("//div[@class='o_r_contact']/ul/li[2]/text()").toString());
        paradiseTeleplay.setAlias(page.getHtml().xpath("//div[@class='o_r_contact']/ul/li[3]/text()").toString());
        paradiseTeleplay.setScriptwriter(page.getHtml().xpath("//div[@class='o_r_contact']/ul/li[4]/span/text()").toString());
        paradiseTeleplay.setDirector(page.getHtml().xpath("//div[@class='o_r_contact']/ul/li[5]/span/text()").toString());
        paradiseTeleplay.setProtagonist(page.getHtml().xpath("//div[@class='o_r_contact']/ul/li[6]/span/text()").toString());
        paradiseTeleplay.setPremiereDate(page.getHtml().xpath("//div[@class='o_r_contact']/ul/li[7]/text()").toString());
        paradiseTeleplay.setTranslate(page.getHtml().xpath("//div[@class='o_r_contact']/ul/li[8]/span/text()").toString());
        paradiseTeleplay.setSubClassification(page.getHtml().xpath("//div[@class='o_r_contact']/ul/li[9]/a/text()").all());
        paradiseTeleplay.setRegion(page.getHtml().xpath("//div[@class='o_r_contact']/ul/li[10]/label/text()").toString());
        paradiseTeleplay.setNextSeason(page.getHtml().xpath("//div[@class='o_r_contact']/ul/li[10]/span/font/text()").toString());
        paradiseTeleplay.setTelevisionStation(page.getHtml().xpath("//div[@class='o_r_contact']/ul/li[11]/label/text()").toString());
        paradiseTeleplay.setRunningTime(page.getHtml().xpath("//div[@class='o_r_contact']/ul/li[11]/span/text()").toString());
        paradiseTeleplay.setDate(page.getHtml().xpath("//div[@class='o_r_contact']/ul/li[12]/label/text()").toString());
        paradiseTeleplay.setType(page.getHtml().xpath("//div[@class='o_r_contact']/ul/li[12]/span/text()").toString());
        paradiseTeleplay.setPoster(page.getHtml().xpath("//div[@class='o_big_img_bg_b']/img/@src").toString());
        return paradiseTeleplay;
    }


}
