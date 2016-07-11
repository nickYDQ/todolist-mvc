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

package io.github.todolist.core.repository.api;

import io.github.todolist.core.domain.Message;

import java.util.List;

/**
 * Interface for message repository.
 *
 * @author Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 */
public interface MessageRepository {

    /**
     * Get message by id.
     *
     * @param id the message's id
     * @return the message having the given id or null if no message found with the given id
     */
    Message getMessageById(final long id);

    /**
     * Get message list for the given user.
     *
     * @param userId the user's id
     * @return the message list for the given user
     */
    List<Message> getMessageListByUser(final long userId);

    /**
     * Get message list by title for the given user.
     *
     * @param title  the message title
     * @param userId the user identifier
     * @return the message list containing the 'title' parameter in their title for the given user
     */
    List<Message> getMessageListByUserAndTitle(final long userId, final String title);

    /**
     * Create a new message.
     *
     * @param message the message to create
     * @return the created message
     */
    Message create(final Message message);

    /**
     * Update a message.
     *
     * @param message the message to update
     * @return the updated message
     */
    Message update(Message message);

    /**
     * Remove a message.
     *
     * @param message the message to remove
     */
    void remove(final Message message);

}
