package cc.airson.im.server.rest.vo;

import lombok.Data;

@Data
public class Message {

    private String  content;
    private Long    ts;
    private Integer state;
    private Integer type;
    private Long    sender;
    private Long    receiver;

}
