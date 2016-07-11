/*
 * The MIT License
 *
 * Copyright (c) 2015, Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package io.github.todolist.core.service.impl;

import io.github.todolist.core.domain.Message;
import io.github.todolist.core.repository.api.MessageRepository;
import io.github.todolist.core.service.api.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of the {@link MessageService}.
 *
 * @author Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 */
@Service
@Transactional(readOnly = true)
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    /**
     * {@inheritDoc}
     */
    public Message getMessageById(final long id) {
        return messageRepository.getMessageById(id);
    }

    /**
     * {@inheritDoc}
     */
    public List<Message> getMessageListByUser(final long userId) {
        return messageRepository.getMessageListByUser(userId);
    }

    /**
     * {@inheritDoc}
     */
    public List<Message> searchMessageListByTitle(final long userId, final String title) {
        return messageRepository.getMessageListByUserAndTitle(userId, title);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    public Message update(Message message) {
        return messageRepository.update(message);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    public Message create(final Message message) {
        return messageRepository.create(message);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    public void remove(final Message message) {
        messageRepository.remove(message);
    }
}
