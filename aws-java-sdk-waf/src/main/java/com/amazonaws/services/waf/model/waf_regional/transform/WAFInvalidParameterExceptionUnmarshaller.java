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
package com.amazonaws.services.waf.model.waf_regional.transform;

import java.math.*;

import javax.annotation.Generated;

import com.amazonaws.services.waf.model.*;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.*;
import com.amazonaws.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * WAFInvalidParameterException JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class WAFInvalidParameterExceptionUnmarshaller extends JsonErrorUnmarshaller<com.amazonaws.services.waf.model.WAFInvalidParameterException> {
    private WAFInvalidParameterExceptionUnmarshaller() {
        super("WAFInvalidParameterException");
    }

    @Override
    public com.amazonaws.services.waf.model.WAFInvalidParameterException unmarshall(JsonUnmarshallerContext context) throws Exception {
        com.amazonaws.services.waf.model.WAFInvalidParameterException wAFInvalidParameterException = new com.amazonaws.services.waf.model.WAFInvalidParameterException(
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
                if (context.testExpression("field", targetDepth)) {
                    context.nextToken();
                    wAFInvalidParameterException.setField(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("parameter", targetDepth)) {
                    context.nextToken();
                    wAFInvalidParameterException.setParameter(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("reason", targetDepth)) {
                    context.nextToken();
                    wAFInvalidParameterException.setReason(context.getUnmarshaller(String.class).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }
        return wAFInvalidParameterException;
    }

    private static WAFInvalidParameterExceptionUnmarshaller instance;

    public static WAFInvalidParameterExceptionUnmarshaller getInstance() {
        if (instance == null)
            instance = new WAFInvalidParameterExceptionUnmarshaller();
        return instance;
    }
}
