/*
 * The MIT License
 *
 *  Copyright (c) 2015, Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */

package io.github.todolist.core.repository.impl;

import io.github.todolist.core.domain.Message;
import io.github.todolist.core.repository.api.MessageRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Implementation of {@link MessageRepository} using JPA.
 *
 * @author Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 */
@Repository
public class MessageRepositoryImpl implements MessageRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    public Message getMessageById(final long id) {
        return entityManager.find(Message.class, id);
    }

    /**
     * {@inheritDoc}
     */
    public List<Message> getMessageListByUser(final long userId) {
        TypedQuery<Message> query = entityManager.createNamedQuery("findMessagesByUser", Message.class);
        query.setParameter(1, userId);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    public List<Message> getMessageListByUserAndTitle(final long userId, final String title) {
        TypedQuery<Message> query = entityManager.createNamedQuery("findMessagesByTitle", Message.class);
        query.setParameter(1, userId);
        query.setParameter(2, "%" + title.toUpperCase() + "%");
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    public Message update(Message message) {
        return entityManager.merge(message);
    }

    /**
     * {@inheritDoc}
     */
    public Message create(final Message message) {
        entityManager.persist(message);
        return message;
    }

    /**
     * {@inheritDoc}
     */
    public void remove(final Message message) {
        Message t = entityManager.find(Message.class, message.getId());
        entityManager.remove(t);
    }

}
