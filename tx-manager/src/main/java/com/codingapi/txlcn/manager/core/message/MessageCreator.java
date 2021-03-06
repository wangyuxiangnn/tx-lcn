/*
 * Copyright 2017-2019 CodingApi .
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.codingapi.txlcn.manager.core.message;

import com.codingapi.txlcn.spi.message.MessageConstants;
import com.codingapi.txlcn.spi.message.dto.MessageDto;
import com.codingapi.txlcn.spi.message.params.GetAspectLogParams;
import com.codingapi.txlcn.spi.message.params.NotifyConnectParams;
import com.codingapi.txlcn.spi.message.params.NotifyUnitParams;

import java.io.Serializable;

/**
 * 消息创建器
 * @author lorne
 */
public class MessageCreator {




    /**
     * 通知TxClient连接
     *
     * @param notifyConnectParams notifyConnectParams
     * @return MessageDto
     */
    public static MessageDto newTxManager(NotifyConnectParams notifyConnectParams) {
        MessageDto msg = new MessageDto();
        msg.setAction(MessageConstants.ACTION_NEW_TXMANAGER);
        msg.setData(notifyConnectParams);
        return msg;
    }

    /**
     * 提交事务组
     *
     * @param notifyUnitParams notifyUnitParams
     * @return MessageDto
     */
    public static MessageDto notifyUnit(NotifyUnitParams notifyUnitParams) {
        MessageDto msg = new MessageDto();
        msg.setGroupId(notifyUnitParams.getGroupId());
        msg.setAction(MessageConstants.ACTION_NOTIFY_UNIT);
        msg.setData(notifyUnitParams);
        return msg;
    }

    /**
     * 关闭事务组正常响应
     * @param action action
     * @param message  message
     * @return MessageDto
     */
    public static MessageDto notifyGroupOkResponse(Serializable message, String action) {
        MessageDto messageDto = new MessageDto();
        messageDto.setState(MessageConstants.STATE_OK);
        messageDto.setAction(action);
        messageDto.setData(message);
        return messageDto;
    }

    /**
     * 关闭事务组失败响应
     * @param action action
     * @param message  message
     * @return MessageDto
     */
    public static MessageDto notifyGroupFailResponse(Serializable message,String action) {
        MessageDto messageDto = new MessageDto();
        messageDto.setAction(action);
        messageDto.setState(MessageConstants.STATE_EXCEPTION);
        messageDto.setData(message);
        return messageDto;
    }

    /**
     * 服务器错误
     * @param action action
     * @return MessageDto
     */
    public static MessageDto serverException(String action) {
        MessageDto messageDto = new MessageDto();
        messageDto.setAction(action);
        messageDto.setState(MessageConstants.STATE_EXCEPTION);
        return messageDto;
    }

    public static MessageDto getAspectLog(String groupId, String unitId) {
        GetAspectLogParams getAspectLogParams = new GetAspectLogParams();
        getAspectLogParams.setGroupId(groupId);
        getAspectLogParams.setUnitId(unitId);

        MessageDto messageDto = new MessageDto();
        messageDto.setGroupId(groupId);
        messageDto.setAction(MessageConstants.ACTION_GET_ASPECT_LOG);
        messageDto.setData(getAspectLogParams);
        return messageDto;
    }
}
