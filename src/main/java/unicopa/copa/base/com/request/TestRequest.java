/*
 * Copyright (C) 2013 UniCoPA
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package unicopa.copa.base.com.request;

/**
 * A request to test the systems handling of the clients requests and the
 * clients handling of the systems responses.
 * 
 * @author Felix Wiemuth
 */
public class TestRequest extends AbstractRequest {
    private int magicNumber;
    private String message;

    /**
     * Create a test request.
     * 
     * @param magicNumber
     *            depending on special numbers sent, the system will send
     *            exceptions or normal answers (0=InternalErrorException,
     *            0-or-less=PermissionException,
     *            42=RequestNotPracticableException, 400=InternalErrorException
     *            because of null)
     * @param message
     *            the message to be sent to the system (the response will
     *            include it somehow); if message="Who am I?" the system will
     *            response with the user ID of the authenticated user
     */
    public TestRequest(int magicNumber, String message) {
	this.magicNumber = magicNumber;
	this.message = message;
    }

    public int getMagicNumber() {
	return magicNumber;
    }

    public String getMessage() {
	return message;
    }
}
