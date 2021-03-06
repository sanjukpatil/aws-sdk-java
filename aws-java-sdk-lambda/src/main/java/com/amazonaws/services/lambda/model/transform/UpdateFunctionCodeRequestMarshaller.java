/*
 * Copyright 2012-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazonaws.services.lambda.model.transform;

import java.io.ByteArrayInputStream;

import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.lambda.model.*;
import com.amazonaws.transform.Marshaller;

import com.amazonaws.protocol.json.*;

/**
 * UpdateFunctionCodeRequest Marshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class UpdateFunctionCodeRequestMarshaller implements Marshaller<Request<UpdateFunctionCodeRequest>, UpdateFunctionCodeRequest> {

    private final SdkJsonMarshallerFactory protocolFactory;

    public UpdateFunctionCodeRequestMarshaller(SdkJsonMarshallerFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    public Request<UpdateFunctionCodeRequest> marshall(UpdateFunctionCodeRequest updateFunctionCodeRequest) {

        if (updateFunctionCodeRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        Request<UpdateFunctionCodeRequest> request = new DefaultRequest<UpdateFunctionCodeRequest>(updateFunctionCodeRequest, "AWSLambda");

        request.setHttpMethod(HttpMethodName.PUT);

        String uriResourcePath = "/2015-03-31/functions/{FunctionName}/code";

        uriResourcePath = com.amazonaws.transform.PathMarshallers.NON_GREEDY.marshall(uriResourcePath, "FunctionName",
                updateFunctionCodeRequest.getFunctionName());
        request.setResourcePath(uriResourcePath);

        try {
            final StructuredJsonGenerator jsonGenerator = protocolFactory.createGenerator();
            jsonGenerator.writeStartObject();

            if (updateFunctionCodeRequest.getZipFile() != null) {
                jsonGenerator.writeFieldName("ZipFile").writeValue(updateFunctionCodeRequest.getZipFile());
            }
            if (updateFunctionCodeRequest.getS3Bucket() != null) {
                jsonGenerator.writeFieldName("S3Bucket").writeValue(updateFunctionCodeRequest.getS3Bucket());
            }
            if (updateFunctionCodeRequest.getS3Key() != null) {
                jsonGenerator.writeFieldName("S3Key").writeValue(updateFunctionCodeRequest.getS3Key());
            }
            if (updateFunctionCodeRequest.getS3ObjectVersion() != null) {
                jsonGenerator.writeFieldName("S3ObjectVersion").writeValue(updateFunctionCodeRequest.getS3ObjectVersion());
            }
            if (updateFunctionCodeRequest.getPublish() != null) {
                jsonGenerator.writeFieldName("Publish").writeValue(updateFunctionCodeRequest.getPublish());
            }

            jsonGenerator.writeEndObject();

            byte[] content = jsonGenerator.getBytes();
            request.setContent(new ByteArrayInputStream(content));
            request.addHeader("Content-Length", Integer.toString(content.length));
            if (!request.getHeaders().containsKey("Content-Type")) {
                request.addHeader("Content-Type", protocolFactory.getContentType());
            }
        } catch (Throwable t) {
            throw new SdkClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }

}
