/*
 * Copyright 2014-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.amazonaws.services.ec2instanceconnect.model.transform;

import java.math.*;

import javax.annotation.Generated;

import com.amazonaws.services.ec2instanceconnect.model.*;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.*;
import com.amazonaws.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * EC2InstanceNotFoundException JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class EC2InstanceNotFoundExceptionUnmarshaller extends
        JsonErrorUnmarshaller<com.amazonaws.services.ec2instanceconnect.model.EC2InstanceNotFoundException> {
    private EC2InstanceNotFoundExceptionUnmarshaller() {
        super("EC2InstanceNotFoundException");
    }

    @Override
    public com.amazonaws.services.ec2instanceconnect.model.EC2InstanceNotFoundException unmarshall(JsonUnmarshallerContext context) throws Exception {
        com.amazonaws.services.ec2instanceconnect.model.EC2InstanceNotFoundException eC2InstanceNotFoundException = new com.amazonaws.services.ec2instanceconnect.model.EC2InstanceNotFoundException(
                null);

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return null;
        }

        while (true) {
            if (token == null)
                break;

            if (token == FIELD_NAME || token == START_OBJECT) {
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }
        return eC2InstanceNotFoundException;
    }

    private static EC2InstanceNotFoundExceptionUnmarshaller instance;

    public static EC2InstanceNotFoundExceptionUnmarshaller getInstance() {
        if (instance == null)
            instance = new EC2InstanceNotFoundExceptionUnmarshaller();
        return instance;
    }
}
