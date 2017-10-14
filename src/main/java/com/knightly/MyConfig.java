package com.knightly;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by knightly on 2017/10/13.
 */
@Configuration
public class MyConfig {

    @Bean
    public TransportClient client() throws UnknownHostException {
        //创建es节点
        InetSocketTransportAddress node = new InetSocketTransportAddress(InetAddress.getByName("localhost"),9300);
        //创建配置对象
        Settings settings = Settings.builder().put("cluster.name","knightly").build();
        //创建client
        TransportClient client = new PreBuiltTransportClient(settings);
        //client向node节点发送请求
        client.addTransportAddress(node);
        return client;
    }


}
