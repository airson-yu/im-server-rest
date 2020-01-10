package cc.airson.im.server.rest.vo;

import lombok.Data;

@Data
public class WebSocketRequest {

    private String  content;
    private Long    ts;
    private Integer state;
    private Integer type;
    private Long    sender;
    private Long    receiver;

    //重要注意事项：收发的消息类，必须存在"无参的默认构造函数"，否则topic订阅会出问题，而且代码不报错！
    /*public WebSocketRequest() {
    }*/

}
