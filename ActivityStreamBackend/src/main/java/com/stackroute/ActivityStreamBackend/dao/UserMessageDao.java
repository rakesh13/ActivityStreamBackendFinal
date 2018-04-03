package com.stackroute.ActivityStreamBackend.dao;

import java.util.List;

import com.stackroute.ActivityStreamBackend.model.UserMessage;




public interface UserMessageDao {

	boolean sendMessage(UserMessage usrmessage);
	boolean deleteMessage(int messageId);
	List<UserMessage> getMyMessages(String emailId);
	List<UserMessage> getAllMessageByCircleName(String circleName);
	boolean isReceiverExists(String receiverEmailId);
	public boolean isCircleExists(String circleName);
	List<UserMessage> getAllMessageByUsers(String senderEmailId, String receiverEmailId);
}
