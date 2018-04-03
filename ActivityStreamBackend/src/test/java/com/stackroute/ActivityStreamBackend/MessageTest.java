package com.stackroute.ActivityStreamBackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.ActivityStreamBackend.dao.MessageDao;
import com.stackroute.ActivityStreamBackend.dao.UserMessageDao;
import com.stackroute.ActivityStreamBackend.model.Message;
import com.stackroute.ActivityStreamBackend.model.UserMessage;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = App.class)
@EnableAspectJAutoProxy
public class MessageTest {

	@Autowired
	 private Message message;
	@Autowired
	private MessageDao messageDao;
	
	@Autowired
	private UserMessage userMessage;
	@Autowired
	private UserMessageDao userMessageDao;
	
	@Ignore
	@Test
	public void sendMessageTest()
	{
		
		message.setMaximumSize(1000000);
		message.setMessageText("Hi....");
		message.setMessageSize(message.getMessageText().length());
		message.setMessageType("Text");
		message.setSenderEmailId("rakesh@gmail.com");
		message.setReceiverEmailId("ramesh@gmail.com");
		assertEquals(true, messageDao.sendMessage(message));
	}
	
	@Ignore
	@Test
	public void getMessagesByIdTest()
	{
		message.setReceiverEmailId("ramesh@gmail.com");
		List<Message> messages=messageDao.getMyMessages(message.getReceiverEmailId());
		assertEquals(1, messages.size());
	}
	
	@Test
    public void getOneToOneMessagesTestCase() {
        List<UserMessage> messages= userMessageDao.getAllMessageByUsers("rakesh@gmail.com", "sujata@gmail.com");
        System.out.println("Message of Rakesh <-> Abbas");
        displayMEssages(messages);
        assertEquals(true,messages.size() >= 0);
    }
	
	private void displayMEssages(List<UserMessage> messages) {
		for(UserMessage stream:messages){
			System.out.println(stream.getMessageId() + "\t"+stream.getMessageText() + "\t" + stream.getReceiverEmailId() + "\t" + stream.getSentDate());
		}
    }
}
