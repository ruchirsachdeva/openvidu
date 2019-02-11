/*
 * (C) Copyright 2017-2019 OpenVidu (https://openvidu.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.openvidu.server.cdr;

import com.google.gson.JsonObject;

public class CDREventEnd extends CDREvent {

	protected Long startTime;
	protected Integer duration;
	protected String reason;

	public CDREventEnd(CDREventName eventName, String sessionId, Long timestamp) {
		super(eventName, sessionId, timestamp);
	}

	public CDREventEnd(CDREventName eventName, String sessionId, Long startTime, String reason) {
		super(eventName, sessionId, System.currentTimeMillis());
		this.startTime = startTime;
		this.duration = (int) ((this.timeStamp - this.startTime) / 1000);
		this.reason = reason;
	}

	@Override
	public JsonObject toJson() {
		JsonObject json = super.toJson();
		if (this.startTime != null) {
			json.addProperty("startTime", this.startTime);
		}
		if (this.duration != null) {
			json.addProperty("duration", this.duration);
		}
		if (this.reason != null) {
			json.addProperty("reason", this.reason);
		}
		return json;
	}

}
