package com.xy.imcore.model;


import com.xy.imcore.enums.IMessageType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * single of chat messages
 *
 * @author dense
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class IMPrivateMessageDto extends IMessageDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * send to somebody
     */
    @NotBlank(message = "接收人id不能为空")
    private String toId;

    /**
     * message type
     */
    private Integer messageType = IMessageType.SINGLE_MESSAGE.getCode();

}
