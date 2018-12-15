package com.wany.purplespider.processor;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

@Component
public class ParadiseTeleplayProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {

        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
        page.putField("name", page.getHtml().xpath("//div[@class='o_r_contact']/ul/li[2]/text()").toString());
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));


    }

    @Override
    public Site getSite() {
        return site;
    }

    public void capture() {
        Spider.create(new ParadiseTeleplayProcessor())
                //从"https://github.com/code4craft"开始抓
                .addUrl("https://www.meijutt.com/content/meiju23924.html")
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


}
