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
package com.amazonaws.services.acmpca;

import org.w3c.dom.*;

import java.net.*;
import java.util.*;

import javax.annotation.Generated;

import org.apache.commons.logging.*;

import com.amazonaws.*;
import com.amazonaws.annotation.SdkInternalApi;
import com.amazonaws.auth.*;

import com.amazonaws.handlers.*;
import com.amazonaws.http.*;
import com.amazonaws.internal.*;
import com.amazonaws.internal.auth.*;
import com.amazonaws.metrics.*;
import com.amazonaws.regions.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.*;
import com.amazonaws.protocol.json.*;
import com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazonaws.annotation.ThreadSafe;
import com.amazonaws.client.AwsSyncClientParams;
import com.amazonaws.client.builder.AdvancedConfig;

import com.amazonaws.services.acmpca.AWSACMPCAClientBuilder;
import com.amazonaws.services.acmpca.waiters.AWSACMPCAWaiters;

import com.amazonaws.AmazonServiceException;

import com.amazonaws.services.acmpca.model.*;
import com.amazonaws.services.acmpca.model.transform.*;

/**
 * Client for accessing ACM-PCA. All service calls made using this client are blocking, and will not return until the
 * service call completes.
 * <p>
 * <p>
 * This is the <i>ACM Private CA API Reference</i>. It provides descriptions, syntax, and usage examples for each of the
 * actions and data types involved in creating and managing private certificate authorities (CA) for your organization.
 * </p>
 * <p>
 * The documentation for each action shows the Query API request parameters and the XML response. Alternatively, you can
 * use one of the AWS SDKs to access an API that's tailored to the programming language or platform that you're using.
 * For more information, see <a href="https://aws.amazon.com/tools/#SDKs">AWS SDKs</a>.
 * </p>
 * <note>
 * <p>
 * Each ACM Private CA API action has a throttling limit which determines the number of times the action can be called
 * per second. For more information, see <a
 * href="https://docs.aws.amazon.com/acm-pca/latest/userguide/PcaLimits.html#PcaLimits-api">API Rate Limits in ACM
 * Private CA</a> in the ACM Private CA user guide.
 * </p>
 * </note>
 */
@ThreadSafe
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class AWSACMPCAClient extends AmazonWebServiceClient implements AWSACMPCA {

    /** Provider for AWS credentials. */
    private final AWSCredentialsProvider awsCredentialsProvider;

    private static final Log log = LogFactory.getLog(AWSACMPCA.class);

    /** Default signing name for the service. */
    private static final String DEFAULT_SIGNING_NAME = "acm-pca";

    private volatile AWSACMPCAWaiters waiters;

    /** Client configuration factory providing ClientConfigurations tailored to this client */
    protected static final ClientConfigurationFactory configFactory = new ClientConfigurationFactory();

    private final AdvancedConfig advancedConfig;

    private static final com.amazonaws.protocol.json.SdkJsonProtocolFactory protocolFactory = new com.amazonaws.protocol.json.SdkJsonProtocolFactory(
            new JsonClientMetadata()
                    .withProtocolVersion("1.1")
                    .withSupportsCbor(false)
                    .withSupportsIon(false)
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata().withErrorCode("InvalidTagException").withExceptionUnmarshaller(
                                    com.amazonaws.services.acmpca.model.transform.InvalidTagExceptionUnmarshaller.getInstance()))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata().withErrorCode("ConcurrentModificationException").withExceptionUnmarshaller(
                                    com.amazonaws.services.acmpca.model.transform.ConcurrentModificationExceptionUnmarshaller.getInstance()))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata().withErrorCode("CertificateMismatchException").withExceptionUnmarshaller(
                                    com.amazonaws.services.acmpca.model.transform.CertificateMismatchExceptionUnmarshaller.getInstance()))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata().withErrorCode("TooManyTagsException").withExceptionUnmarshaller(
                                    com.amazonaws.services.acmpca.model.transform.TooManyTagsExceptionUnmarshaller.getInstance()))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata().withErrorCode("InvalidPolicyException").withExceptionUnmarshaller(
                                    com.amazonaws.services.acmpca.model.transform.InvalidPolicyExceptionUnmarshaller.getInstance()))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata().withErrorCode("InvalidRequestException").withExceptionUnmarshaller(
                                    com.amazonaws.services.acmpca.model.transform.InvalidRequestExceptionUnmarshaller.getInstance()))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata().withErrorCode("ResourceNotFoundException").withExceptionUnmarshaller(
                                    com.amazonaws.services.acmpca.model.transform.ResourceNotFoundExceptionUnmarshaller.getInstance()))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata().withErrorCode("InvalidArgsException").withExceptionUnmarshaller(
                                    com.amazonaws.services.acmpca.model.transform.InvalidArgsExceptionUnmarshaller.getInstance()))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata().withErrorCode("InvalidArnException").withExceptionUnmarshaller(
                                    com.amazonaws.services.acmpca.model.transform.InvalidArnExceptionUnmarshaller.getInstance()))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata().withErrorCode("MalformedCSRException").withExceptionUnmarshaller(
                                    com.amazonaws.services.acmpca.model.transform.MalformedCSRExceptionUnmarshaller.getInstance()))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata().withErrorCode("RequestInProgressException").withExceptionUnmarshaller(
                                    com.amazonaws.services.acmpca.model.transform.RequestInProgressExceptionUnmarshaller.getInstance()))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata().withErrorCode("InvalidStateException").withExceptionUnmarshaller(
                                    com.amazonaws.services.acmpca.model.transform.InvalidStateExceptionUnmarshaller.getInstance()))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata().withErrorCode("PermissionAlreadyExistsException").withExceptionUnmarshaller(
                                    com.amazonaws.services.acmpca.model.transform.PermissionAlreadyExistsExceptionUnmarshaller.getInstance()))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata().withErrorCode("RequestAlreadyProcessedException").withExceptionUnmarshaller(
                                    com.amazonaws.services.acmpca.model.transform.RequestAlreadyProcessedExceptionUnmarshaller.getInstance()))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata().withErrorCode("MalformedCertificateException").withExceptionUnmarshaller(
                                    com.amazonaws.services.acmpca.model.transform.MalformedCertificateExceptionUnmarshaller.getInstance()))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata().withErrorCode("RequestFailedException").withExceptionUnmarshaller(
                                    com.amazonaws.services.acmpca.model.transform.RequestFailedExceptionUnmarshaller.getInstance()))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata().withErrorCode("InvalidNextTokenException").withExceptionUnmarshaller(
                                    com.amazonaws.services.acmpca.model.transform.InvalidNextTokenExceptionUnmarshaller.getInstance()))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata().withErrorCode("LimitExceededException").withExceptionUnmarshaller(
                                    com.amazonaws.services.acmpca.model.transform.LimitExceededExceptionUnmarshaller.getInstance()))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata().withErrorCode(null).withExceptionUnmarshaller(
                                    new JsonBaseExceptionUnmarshaller<com.amazonaws.services.acmpca.model.AWSACMPCAException>(
                                            com.amazonaws.services.acmpca.model.AWSACMPCAException.class))));

    public static AWSACMPCAClientBuilder builder() {
        return AWSACMPCAClientBuilder.standard();
    }

    /**
     * Constructs a new client to invoke service methods on ACM-PCA using the specified parameters.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not return until the service call
     * completes.
     *
     * @param clientParams
     *        Object providing client parameters.
     */
    AWSACMPCAClient(AwsSyncClientParams clientParams) {
        this(clientParams, false);
    }

    /**
     * Constructs a new client to invoke service methods on ACM-PCA using the specified parameters.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not return until the service call
     * completes.
     *
     * @param clientParams
     *        Object providing client parameters.
     */
    AWSACMPCAClient(AwsSyncClientParams clientParams, boolean endpointDiscoveryEnabled) {
        super(clientParams);
        this.awsCredentialsProvider = clientParams.getCredentialsProvider();
        this.advancedConfig = clientParams.getAdvancedConfig();
        init();
    }

    private void init() {
        setServiceNameIntern(DEFAULT_SIGNING_NAME);
        setEndpointPrefix(ENDPOINT_PREFIX);
        // calling this.setEndPoint(...) will also modify the signer accordingly
        setEndpoint("acm-pca.us-east-1.amazonaws.com");
        HandlerChainFactory chainFactory = new HandlerChainFactory();
        requestHandler2s.addAll(chainFactory.newRequestHandlerChain("/com/amazonaws/services/acmpca/request.handlers"));
        requestHandler2s.addAll(chainFactory.newRequestHandler2Chain("/com/amazonaws/services/acmpca/request.handler2s"));
        requestHandler2s.addAll(chainFactory.getGlobalHandlers());
    }

    /**
     * <p>
     * Creates a root or subordinate private certificate authority (CA). You must specify the CA configuration, the
     * certificate revocation list (CRL) configuration, the CA type, and an optional idempotency token to avoid
     * accidental creation of multiple CAs. The CA configuration specifies the name of the algorithm and key size to be
     * used to create the CA private key, the type of signing algorithm that the CA uses, and X.500 subject information.
     * The CRL configuration specifies the CRL expiration period in days (the validity period of the CRL), the Amazon S3
     * bucket that will contain the CRL, and a CNAME alias for the S3 bucket that is included in certificates issued by
     * the CA. If successful, this action returns the Amazon Resource Name (ARN) of the CA.
     * </p>
     * 
     * @param createCertificateAuthorityRequest
     * @return Result of the CreateCertificateAuthority operation returned by the service.
     * @throws InvalidArgsException
     *         One or more of the specified arguments was not valid.
     * @throws InvalidPolicyException
     *         The S3 bucket policy is not valid. The policy must give ACM Private CA rights to read from and write to
     *         the bucket and find the bucket location.
     * @throws InvalidTagException
     *         The tag associated with the CA is not valid. The invalid argument is contained in the message field.
     * @throws LimitExceededException
     *         An ACM Private CA limit has been exceeded. See the exception message returned to determine the limit that
     *         was exceeded.
     * @sample AWSACMPCA.CreateCertificateAuthority
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/acm-pca-2017-08-22/CreateCertificateAuthority"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public CreateCertificateAuthorityResult createCertificateAuthority(CreateCertificateAuthorityRequest request) {
        request = beforeClientExecution(request);
        return executeCreateCertificateAuthority(request);
    }

    @SdkInternalApi
    final CreateCertificateAuthorityResult executeCreateCertificateAuthority(CreateCertificateAuthorityRequest createCertificateAuthorityRequest) {

        ExecutionContext executionContext = createExecutionContext(createCertificateAuthorityRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateCertificateAuthorityRequest> request = null;
        Response<CreateCertificateAuthorityResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateCertificateAuthorityRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(createCertificateAuthorityRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "ACM PCA");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateCertificateAuthority");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);

            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<CreateCertificateAuthorityResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new CreateCertificateAuthorityResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates an audit report that lists every time that your CA private key is used. The report is saved in the Amazon
     * S3 bucket that you specify on input. The <a>IssueCertificate</a> and <a>RevokeCertificate</a> actions use the
     * private key.
     * </p>
     * 
     * @param createCertificateAuthorityAuditReportRequest
     * @return Result of the CreateCertificateAuthorityAuditReport operation returned by the service.
     * @throws RequestInProgressException
     *         Your request is already in progress.
     * @throws RequestFailedException
     *         The request has failed for an unspecified reason.
     * @throws ResourceNotFoundException
     *         A resource such as a private CA, S3 bucket, certificate, or audit report cannot be found.
     * @throws InvalidArnException
     *         The requested Amazon Resource Name (ARN) does not refer to an existing resource.
     * @throws InvalidArgsException
     *         One or more of the specified arguments was not valid.
     * @throws InvalidStateException
     *         The private CA is in a state during which a report or certificate cannot be generated.
     * @sample AWSACMPCA.CreateCertificateAuthorityAuditReport
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/acm-pca-2017-08-22/CreateCertificateAuthorityAuditReport"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public CreateCertificateAuthorityAuditReportResult createCertificateAuthorityAuditReport(CreateCertificateAuthorityAuditReportRequest request) {
        request = beforeClientExecution(request);
        return executeCreateCertificateAuthorityAuditReport(request);
    }

    @SdkInternalApi
    final CreateCertificateAuthorityAuditReportResult executeCreateCertificateAuthorityAuditReport(
            CreateCertificateAuthorityAuditReportRequest createCertificateAuthorityAuditReportRequest) {

        ExecutionContext executionContext = createExecutionContext(createCertificateAuthorityAuditReportRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateCertificateAuthorityAuditReportRequest> request = null;
        Response<CreateCertificateAuthorityAuditReportResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateCertificateAuthorityAuditReportRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(createCertificateAuthorityAuditReportRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "ACM PCA");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateCertificateAuthorityAuditReport");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);

            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<CreateCertificateAuthorityAuditReportResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new CreateCertificateAuthorityAuditReportResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Assigns permissions from a private CA to a designated AWS service. Services are specified by their service
     * principals and can be given permission to create and retrieve certificates on a private CA. Services can also be
     * given permission to list the active permissions that the private CA has granted. For ACM to automatically renew
     * your private CA's certificates, you must assign all possible permissions from the CA to the ACM service
     * principal.
     * </p>
     * <p>
     * At this time, you can only assign permissions to ACM (<code>acm.amazonaws.com</code>). Permissions can be revoked
     * with the <a>DeletePermission</a> action and listed with the <a>ListPermissions</a> action.
     * </p>
     * 
     * @param createPermissionRequest
     * @return Result of the CreatePermission operation returned by the service.
     * @throws ResourceNotFoundException
     *         A resource such as a private CA, S3 bucket, certificate, or audit report cannot be found.
     * @throws InvalidArnException
     *         The requested Amazon Resource Name (ARN) does not refer to an existing resource.
     * @throws PermissionAlreadyExistsException
     *         The designated permission has already been given to the user.
     * @throws LimitExceededException
     *         An ACM Private CA limit has been exceeded. See the exception message returned to determine the limit that
     *         was exceeded.
     * @throws InvalidStateException
     *         The private CA is in a state during which a report or certificate cannot be generated.
     * @throws RequestFailedException
     *         The request has failed for an unspecified reason.
     * @sample AWSACMPCA.CreatePermission
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/acm-pca-2017-08-22/CreatePermission" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreatePermissionResult createPermission(CreatePermissionRequest request) {
        request = beforeClientExecution(request);
        return executeCreatePermission(request);
    }

    @SdkInternalApi
    final CreatePermissionResult executeCreatePermission(CreatePermissionRequest createPermissionRequest) {

        ExecutionContext executionContext = createExecutionContext(createPermissionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreatePermissionRequest> request = null;
        Response<CreatePermissionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreatePermissionRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(createPermissionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "ACM PCA");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreatePermission");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);

            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<CreatePermissionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new CreatePermissionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes a private certificate authority (CA). You must provide the Amazon Resource Name (ARN) of the private CA
     * that you want to delete. You can find the ARN by calling the <a>ListCertificateAuthorities</a> action.
     * </p>
     * <note>
     * <p>
     * Deleting a CA will invalidate other CAs and certificates below it in your CA hierarchy.
     * </p>
     * </note>
     * <p>
     * Before you can delete a CA that you have created and activated, you must disable it. To do this, call the
     * <a>UpdateCertificateAuthority</a> action and set the <b>CertificateAuthorityStatus</b> parameter to
     * <code>DISABLED</code>.
     * </p>
     * <p>
     * Additionally, you can delete a CA if you are waiting for it to be created (that is, the status of the CA is
     * <code>CREATING</code>). You can also delete it if the CA has been created but you haven't yet imported the signed
     * certificate into ACM Private CA (that is, the status of the CA is <code>PENDING_CERTIFICATE</code>).
     * </p>
     * <p>
     * When you successfully call <a>DeleteCertificateAuthority</a>, the CA's status changes to <code>DELETED</code>.
     * However, the CA won't be permanently deleted until the restoration period has passed. By default, if you do not
     * set the <code>PermanentDeletionTimeInDays</code> parameter, the CA remains restorable for 30 days. You can set
     * the parameter from 7 to 30 days. The <a>DescribeCertificateAuthority</a> action returns the time remaining in the
     * restoration window of a private CA in the <code>DELETED</code> state. To restore an eligible CA, call the
     * <a>RestoreCertificateAuthority</a> action.
     * </p>
     * 
     * @param deleteCertificateAuthorityRequest
     * @return Result of the DeleteCertificateAuthority operation returned by the service.
     * @throws ConcurrentModificationException
     *         A previous update to your private CA is still ongoing.
     * @throws ResourceNotFoundException
     *         A resource such as a private CA, S3 bucket, certificate, or audit report cannot be found.
     * @throws InvalidArnException
     *         The requested Amazon Resource Name (ARN) does not refer to an existing resource.
     * @throws InvalidStateException
     *         The private CA is in a state during which a report or certificate cannot be generated.
     * @sample AWSACMPCA.DeleteCertificateAuthority
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/acm-pca-2017-08-22/DeleteCertificateAuthority"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DeleteCertificateAuthorityResult deleteCertificateAuthority(DeleteCertificateAuthorityRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteCertificateAuthority(request);
    }

    @SdkInternalApi
    final DeleteCertificateAuthorityResult executeDeleteCertificateAuthority(DeleteCertificateAuthorityRequest deleteCertificateAuthorityRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteCertificateAuthorityRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteCertificateAuthorityRequest> request = null;
        Response<DeleteCertificateAuthorityResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteCertificateAuthorityRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(deleteCertificateAuthorityRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "ACM PCA");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteCertificateAuthority");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);

            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<DeleteCertificateAuthorityResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new DeleteCertificateAuthorityResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Revokes permissions that a private CA assigned to a designated AWS service. Permissions can be created with the
     * <a>CreatePermission</a> action and listed with the <a>ListPermissions</a> action.
     * </p>
     * 
     * @param deletePermissionRequest
     * @return Result of the DeletePermission operation returned by the service.
     * @throws ResourceNotFoundException
     *         A resource such as a private CA, S3 bucket, certificate, or audit report cannot be found.
     * @throws InvalidArnException
     *         The requested Amazon Resource Name (ARN) does not refer to an existing resource.
     * @throws InvalidStateException
     *         The private CA is in a state during which a report or certificate cannot be generated.
     * @throws RequestFailedException
     *         The request has failed for an unspecified reason.
     * @sample AWSACMPCA.DeletePermission
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/acm-pca-2017-08-22/DeletePermission" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeletePermissionResult deletePermission(DeletePermissionRequest request) {
        request = beforeClientExecution(request);
        return executeDeletePermission(request);
    }

    @SdkInternalApi
    final DeletePermissionResult executeDeletePermission(DeletePermissionRequest deletePermissionRequest) {

        ExecutionContext executionContext = createExecutionContext(deletePermissionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeletePermissionRequest> request = null;
        Response<DeletePermissionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeletePermissionRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(deletePermissionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "ACM PCA");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeletePermission");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);

            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<DeletePermissionResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new DeletePermissionResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Lists information about your private certificate authority (CA). You specify the private CA on input by its ARN
     * (Amazon Resource Name). The output contains the status of your CA. This can be any of the following:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>CREATING</code> - ACM Private CA is creating your private certificate authority.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>PENDING_CERTIFICATE</code> - The certificate is pending. You must use your ACM Private CA-hosted or
     * on-premises root or subordinate CA to sign your private CA CSR and then import it into PCA.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>ACTIVE</code> - Your private CA is active.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>DISABLED</code> - Your private CA has been disabled.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>EXPIRED</code> - Your private CA certificate has expired.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>FAILED</code> - Your private CA has failed. Your CA can fail because of problems such a network outage or
     * backend AWS failure or other errors. A failed CA can never return to the pending state. You must create a new CA.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>DELETED</code> - Your private CA is within the restoration period, after which it is permanently deleted.
     * The length of time remaining in the CA's restoration period is also included in this action's output.
     * </p>
     * </li>
     * </ul>
     * 
     * @param describeCertificateAuthorityRequest
     * @return Result of the DescribeCertificateAuthority operation returned by the service.
     * @throws ResourceNotFoundException
     *         A resource such as a private CA, S3 bucket, certificate, or audit report cannot be found.
     * @throws InvalidArnException
     *         The requested Amazon Resource Name (ARN) does not refer to an existing resource.
     * @sample AWSACMPCA.DescribeCertificateAuthority
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/acm-pca-2017-08-22/DescribeCertificateAuthority"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeCertificateAuthorityResult describeCertificateAuthority(DescribeCertificateAuthorityRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeCertificateAuthority(request);
    }

    @SdkInternalApi
    final DescribeCertificateAuthorityResult executeDescribeCertificateAuthority(DescribeCertificateAuthorityRequest describeCertificateAuthorityRequest) {

        ExecutionContext executionContext = createExecutionContext(describeCertificateAuthorityRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeCertificateAuthorityRequest> request = null;
        Response<DescribeCertificateAuthorityResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeCertificateAuthorityRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(describeCertificateAuthorityRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "ACM PCA");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeCertificateAuthority");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);

            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<DescribeCertificateAuthorityResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new DescribeCertificateAuthorityResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Lists information about a specific audit report created by calling the
     * <a>CreateCertificateAuthorityAuditReport</a> action. Audit information is created every time the certificate
     * authority (CA) private key is used. The private key is used when you call the <a>IssueCertificate</a> action or
     * the <a>RevokeCertificate</a> action.
     * </p>
     * 
     * @param describeCertificateAuthorityAuditReportRequest
     * @return Result of the DescribeCertificateAuthorityAuditReport operation returned by the service.
     * @throws ResourceNotFoundException
     *         A resource such as a private CA, S3 bucket, certificate, or audit report cannot be found.
     * @throws InvalidArnException
     *         The requested Amazon Resource Name (ARN) does not refer to an existing resource.
     * @throws InvalidArgsException
     *         One or more of the specified arguments was not valid.
     * @sample AWSACMPCA.DescribeCertificateAuthorityAuditReport
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/acm-pca-2017-08-22/DescribeCertificateAuthorityAuditReport"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeCertificateAuthorityAuditReportResult describeCertificateAuthorityAuditReport(DescribeCertificateAuthorityAuditReportRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeCertificateAuthorityAuditReport(request);
    }

    @SdkInternalApi
    final DescribeCertificateAuthorityAuditReportResult executeDescribeCertificateAuthorityAuditReport(
            DescribeCertificateAuthorityAuditReportRequest describeCertificateAuthorityAuditReportRequest) {

        ExecutionContext executionContext = createExecutionContext(describeCertificateAuthorityAuditReportRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeCertificateAuthorityAuditReportRequest> request = null;
        Response<DescribeCertificateAuthorityAuditReportResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeCertificateAuthorityAuditReportRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(describeCertificateAuthorityAuditReportRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "ACM PCA");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeCertificateAuthorityAuditReport");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);

            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<DescribeCertificateAuthorityAuditReportResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                            new DescribeCertificateAuthorityAuditReportResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Retrieves a certificate from your private CA. The ARN of the certificate is returned when you call the
     * <a>IssueCertificate</a> action. You must specify both the ARN of your private CA and the ARN of the issued
     * certificate when calling the <b>GetCertificate</b> action. You can retrieve the certificate if it is in the
     * <b>ISSUED</b> state. You can call the <a>CreateCertificateAuthorityAuditReport</a> action to create a report that
     * contains information about all of the certificates issued and revoked by your private CA.
     * </p>
     * 
     * @param getCertificateRequest
     * @return Result of the GetCertificate operation returned by the service.
     * @throws RequestInProgressException
     *         Your request is already in progress.
     * @throws RequestFailedException
     *         The request has failed for an unspecified reason.
     * @throws ResourceNotFoundException
     *         A resource such as a private CA, S3 bucket, certificate, or audit report cannot be found.
     * @throws InvalidArnException
     *         The requested Amazon Resource Name (ARN) does not refer to an existing resource.
     * @throws InvalidStateException
     *         The private CA is in a state during which a report or certificate cannot be generated.
     * @sample AWSACMPCA.GetCertificate
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/acm-pca-2017-08-22/GetCertificate" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public GetCertificateResult getCertificate(GetCertificateRequest request) {
        request = beforeClientExecution(request);
        return executeGetCertificate(request);
    }

    @SdkInternalApi
    final GetCertificateResult executeGetCertificate(GetCertificateRequest getCertificateRequest) {

        ExecutionContext executionContext = createExecutionContext(getCertificateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetCertificateRequest> request = null;
        Response<GetCertificateResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetCertificateRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(getCertificateRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "ACM PCA");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetCertificate");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);

            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetCertificateResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new GetCertificateResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Retrieves the certificate and certificate chain for your private certificate authority (CA). Both the certificate
     * and the chain are base64 PEM-encoded. The chain does not include the CA certificate. Each certificate in the
     * chain signs the one before it.
     * </p>
     * 
     * @param getCertificateAuthorityCertificateRequest
     * @return Result of the GetCertificateAuthorityCertificate operation returned by the service.
     * @throws ResourceNotFoundException
     *         A resource such as a private CA, S3 bucket, certificate, or audit report cannot be found.
     * @throws InvalidStateException
     *         The private CA is in a state during which a report or certificate cannot be generated.
     * @throws InvalidArnException
     *         The requested Amazon Resource Name (ARN) does not refer to an existing resource.
     * @sample AWSACMPCA.GetCertificateAuthorityCertificate
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/acm-pca-2017-08-22/GetCertificateAuthorityCertificate"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public GetCertificateAuthorityCertificateResult getCertificateAuthorityCertificate(GetCertificateAuthorityCertificateRequest request) {
        request = beforeClientExecution(request);
        return executeGetCertificateAuthorityCertificate(request);
    }

    @SdkInternalApi
    final GetCertificateAuthorityCertificateResult executeGetCertificateAuthorityCertificate(
            GetCertificateAuthorityCertificateRequest getCertificateAuthorityCertificateRequest) {

        ExecutionContext executionContext = createExecutionContext(getCertificateAuthorityCertificateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetCertificateAuthorityCertificateRequest> request = null;
        Response<GetCertificateAuthorityCertificateResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetCertificateAuthorityCertificateRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(getCertificateAuthorityCertificateRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "ACM PCA");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetCertificateAuthorityCertificate");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);

            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetCertificateAuthorityCertificateResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new GetCertificateAuthorityCertificateResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Retrieves the certificate signing request (CSR) for your private certificate authority (CA). The CSR is created
     * when you call the <a>CreateCertificateAuthority</a> action. Sign the CSR with your ACM Private CA-hosted or
     * on-premises root or subordinate CA. Then import the signed certificate back into ACM Private CA by calling the
     * <a>ImportCertificateAuthorityCertificate</a> action. The CSR is returned as a base64 PEM-encoded string.
     * </p>
     * 
     * @param getCertificateAuthorityCsrRequest
     * @return Result of the GetCertificateAuthorityCsr operation returned by the service.
     * @throws RequestInProgressException
     *         Your request is already in progress.
     * @throws RequestFailedException
     *         The request has failed for an unspecified reason.
     * @throws ResourceNotFoundException
     *         A resource such as a private CA, S3 bucket, certificate, or audit report cannot be found.
     * @throws InvalidArnException
     *         The requested Amazon Resource Name (ARN) does not refer to an existing resource.
     * @throws InvalidStateException
     *         The private CA is in a state during which a report or certificate cannot be generated.
     * @sample AWSACMPCA.GetCertificateAuthorityCsr
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/acm-pca-2017-08-22/GetCertificateAuthorityCsr"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public GetCertificateAuthorityCsrResult getCertificateAuthorityCsr(GetCertificateAuthorityCsrRequest request) {
        request = beforeClientExecution(request);
        return executeGetCertificateAuthorityCsr(request);
    }

    @SdkInternalApi
    final GetCertificateAuthorityCsrResult executeGetCertificateAuthorityCsr(GetCertificateAuthorityCsrRequest getCertificateAuthorityCsrRequest) {

        ExecutionContext executionContext = createExecutionContext(getCertificateAuthorityCsrRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetCertificateAuthorityCsrRequest> request = null;
        Response<GetCertificateAuthorityCsrResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetCertificateAuthorityCsrRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(getCertificateAuthorityCsrRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "ACM PCA");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetCertificateAuthorityCsr");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);

            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetCertificateAuthorityCsrResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new GetCertificateAuthorityCsrResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Imports a signed private CA certificate into ACM Private CA. This action is used when you are using a chain of
     * trust whose root is located outside ACM Private CA. Before you can call this action, the following preparations
     * must in place:
     * </p>
     * <ol>
     * <li>
     * <p>
     * In ACM Private CA, call the <a>CreateCertificateAuthority</a> action to create the private CA that that you plan
     * to back with the imported certificate.
     * </p>
     * </li>
     * <li>
     * <p>
     * Call the <a>GetCertificateAuthorityCsr</a> action to generate a certificate signing request (CSR).
     * </p>
     * </li>
     * <li>
     * <p>
     * Sign the CSR using a root or intermediate CA hosted either by an on-premises PKI hierarchy or a commercial CA..
     * </p>
     * </li>
     * <li>
     * <p>
     * Create a certificate chain and copy the signed certificate and the certificate chain to your working directory.
     * </p>
     * </li>
     * </ol>
     * <p>
     * The following requirements apply when you import a CA certificate.
     * </p>
     * <ul>
     * <li>
     * <p>
     * You cannot import a non-self-signed certificate for use as a root CA.
     * </p>
     * </li>
     * <li>
     * <p>
     * You cannot import a self-signed certificate for use as a subordinate CA.
     * </p>
     * </li>
     * <li>
     * <p>
     * Your certificate chain must not include the private CA certificate that you are importing.
     * </p>
     * </li>
     * <li>
     * <p>
     * Your ACM Private CA-hosted or on-premises CA certificate must be the last certificate in your chain. The
     * subordinate certificate, if any, that your root CA signed must be next to last. The subordinate certificate
     * signed by the preceding subordinate CA must come next, and so on until your chain is built.
     * </p>
     * </li>
     * <li>
     * <p>
     * The chain must be PEM-encoded.
     * </p>
     * </li>
     * </ul>
     * 
     * @param importCertificateAuthorityCertificateRequest
     * @return Result of the ImportCertificateAuthorityCertificate operation returned by the service.
     * @throws ConcurrentModificationException
     *         A previous update to your private CA is still ongoing.
     * @throws RequestInProgressException
     *         Your request is already in progress.
     * @throws RequestFailedException
     *         The request has failed for an unspecified reason.
     * @throws ResourceNotFoundException
     *         A resource such as a private CA, S3 bucket, certificate, or audit report cannot be found.
     * @throws InvalidArnException
     *         The requested Amazon Resource Name (ARN) does not refer to an existing resource.
     * @throws InvalidRequestException
     *         The request action cannot be performed or is prohibited.
     * @throws InvalidStateException
     *         The private CA is in a state during which a report or certificate cannot be generated.
     * @throws MalformedCertificateException
     *         One or more fields in the certificate are invalid.
     * @throws CertificateMismatchException
     *         The certificate authority certificate you are importing does not comply with conditions specified in the
     *         certificate that signed it.
     * @sample AWSACMPCA.ImportCertificateAuthorityCertificate
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/acm-pca-2017-08-22/ImportCertificateAuthorityCertificate"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ImportCertificateAuthorityCertificateResult importCertificateAuthorityCertificate(ImportCertificateAuthorityCertificateRequest request) {
        request = beforeClientExecution(request);
        return executeImportCertificateAuthorityCertificate(request);
    }

    @SdkInternalApi
    final ImportCertificateAuthorityCertificateResult executeImportCertificateAuthorityCertificate(
            ImportCertificateAuthorityCertificateRequest importCertificateAuthorityCertificateRequest) {

        ExecutionContext executionContext = createExecutionContext(importCertificateAuthorityCertificateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ImportCertificateAuthorityCertificateRequest> request = null;
        Response<ImportCertificateAuthorityCertificateResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ImportCertificateAuthorityCertificateRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(importCertificateAuthorityCertificateRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "ACM PCA");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ImportCertificateAuthorityCertificate");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);

            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<ImportCertificateAuthorityCertificateResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new ImportCertificateAuthorityCertificateResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Uses your private certificate authority (CA) to issue a client certificate. This action returns the Amazon
     * Resource Name (ARN) of the certificate. You can retrieve the certificate by calling the <a>GetCertificate</a>
     * action and specifying the ARN.
     * </p>
     * <note>
     * <p>
     * You cannot use the ACM <b>ListCertificateAuthorities</b> action to retrieve the ARNs of the certificates that you
     * issue by using ACM Private CA.
     * </p>
     * </note>
     * 
     * @param issueCertificateRequest
     * @return Result of the IssueCertificate operation returned by the service.
     * @throws LimitExceededException
     *         An ACM Private CA limit has been exceeded. See the exception message returned to determine the limit that
     *         was exceeded.
     * @throws ResourceNotFoundException
     *         A resource such as a private CA, S3 bucket, certificate, or audit report cannot be found.
     * @throws InvalidStateException
     *         The private CA is in a state during which a report or certificate cannot be generated.
     * @throws InvalidArnException
     *         The requested Amazon Resource Name (ARN) does not refer to an existing resource.
     * @throws InvalidArgsException
     *         One or more of the specified arguments was not valid.
     * @throws MalformedCSRException
     *         The certificate signing request is invalid.
     * @sample AWSACMPCA.IssueCertificate
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/acm-pca-2017-08-22/IssueCertificate" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public IssueCertificateResult issueCertificate(IssueCertificateRequest request) {
        request = beforeClientExecution(request);
        return executeIssueCertificate(request);
    }

    @SdkInternalApi
    final IssueCertificateResult executeIssueCertificate(IssueCertificateRequest issueCertificateRequest) {

        ExecutionContext executionContext = createExecutionContext(issueCertificateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<IssueCertificateRequest> request = null;
        Response<IssueCertificateResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new IssueCertificateRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(issueCertificateRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "ACM PCA");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "IssueCertificate");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);

            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<IssueCertificateResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new IssueCertificateResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Lists the private certificate authorities that you created by using the <a>CreateCertificateAuthority</a> action.
     * </p>
     * 
     * @param listCertificateAuthoritiesRequest
     * @return Result of the ListCertificateAuthorities operation returned by the service.
     * @throws InvalidNextTokenException
     *         The token specified in the <code>NextToken</code> argument is not valid. Use the token returned from your
     *         previous call to <a>ListCertificateAuthorities</a>.
     * @sample AWSACMPCA.ListCertificateAuthorities
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/acm-pca-2017-08-22/ListCertificateAuthorities"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ListCertificateAuthoritiesResult listCertificateAuthorities(ListCertificateAuthoritiesRequest request) {
        request = beforeClientExecution(request);
        return executeListCertificateAuthorities(request);
    }

    @SdkInternalApi
    final ListCertificateAuthoritiesResult executeListCertificateAuthorities(ListCertificateAuthoritiesRequest listCertificateAuthoritiesRequest) {

        ExecutionContext executionContext = createExecutionContext(listCertificateAuthoritiesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListCertificateAuthoritiesRequest> request = null;
        Response<ListCertificateAuthoritiesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListCertificateAuthoritiesRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(listCertificateAuthoritiesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "ACM PCA");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListCertificateAuthorities");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);

            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<ListCertificateAuthoritiesResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new ListCertificateAuthoritiesResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Lists all the permissions, if any, that have been assigned by a private CA. Permissions can be granted with the
     * <a>CreatePermission</a> action and revoked with the <a>DeletePermission</a> action.
     * </p>
     * 
     * @param listPermissionsRequest
     * @return Result of the ListPermissions operation returned by the service.
     * @throws ResourceNotFoundException
     *         A resource such as a private CA, S3 bucket, certificate, or audit report cannot be found.
     * @throws InvalidArnException
     *         The requested Amazon Resource Name (ARN) does not refer to an existing resource.
     * @throws InvalidNextTokenException
     *         The token specified in the <code>NextToken</code> argument is not valid. Use the token returned from your
     *         previous call to <a>ListCertificateAuthorities</a>.
     * @throws InvalidStateException
     *         The private CA is in a state during which a report or certificate cannot be generated.
     * @throws RequestFailedException
     *         The request has failed for an unspecified reason.
     * @sample AWSACMPCA.ListPermissions
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/acm-pca-2017-08-22/ListPermissions" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ListPermissionsResult listPermissions(ListPermissionsRequest request) {
        request = beforeClientExecution(request);
        return executeListPermissions(request);
    }

    @SdkInternalApi
    final ListPermissionsResult executeListPermissions(ListPermissionsRequest listPermissionsRequest) {

        ExecutionContext executionContext = createExecutionContext(listPermissionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListPermissionsRequest> request = null;
        Response<ListPermissionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListPermissionsRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(listPermissionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "ACM PCA");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListPermissions");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);

            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<ListPermissionsResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new ListPermissionsResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Lists the tags, if any, that are associated with your private CA. Tags are labels that you can use to identify
     * and organize your CAs. Each tag consists of a key and an optional value. Call the <a>TagCertificateAuthority</a>
     * action to add one or more tags to your CA. Call the <a>UntagCertificateAuthority</a> action to remove tags.
     * </p>
     * 
     * @param listTagsRequest
     * @return Result of the ListTags operation returned by the service.
     * @throws ResourceNotFoundException
     *         A resource such as a private CA, S3 bucket, certificate, or audit report cannot be found.
     * @throws InvalidArnException
     *         The requested Amazon Resource Name (ARN) does not refer to an existing resource.
     * @throws InvalidStateException
     *         The private CA is in a state during which a report or certificate cannot be generated.
     * @sample AWSACMPCA.ListTags
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/acm-pca-2017-08-22/ListTags" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ListTagsResult listTags(ListTagsRequest request) {
        request = beforeClientExecution(request);
        return executeListTags(request);
    }

    @SdkInternalApi
    final ListTagsResult executeListTags(ListTagsRequest listTagsRequest) {

        ExecutionContext executionContext = createExecutionContext(listTagsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListTagsRequest> request = null;
        Response<ListTagsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListTagsRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(listTagsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "ACM PCA");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListTags");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);

            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<ListTagsResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
                    .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ListTagsResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Restores a certificate authority (CA) that is in the <code>DELETED</code> state. You can restore a CA during the
     * period that you defined in the <b>PermanentDeletionTimeInDays</b> parameter of the
     * <a>DeleteCertificateAuthority</a> action. Currently, you can specify 7 to 30 days. If you did not specify a
     * <b>PermanentDeletionTimeInDays</b> value, by default you can restore the CA at any time in a 30 day period. You
     * can check the time remaining in the restoration period of a private CA in the <code>DELETED</code> state by
     * calling the <a>DescribeCertificateAuthority</a> or <a>ListCertificateAuthorities</a> actions. The status of a
     * restored CA is set to its pre-deletion status when the <b>RestoreCertificateAuthority</b> action returns. To
     * change its status to <code>ACTIVE</code>, call the <a>UpdateCertificateAuthority</a> action. If the private CA
     * was in the <code>PENDING_CERTIFICATE</code> state at deletion, you must use the
     * <a>ImportCertificateAuthorityCertificate</a> action to import a certificate authority into the private CA before
     * it can be activated. You cannot restore a CA after the restoration period has ended.
     * </p>
     * 
     * @param restoreCertificateAuthorityRequest
     * @return Result of the RestoreCertificateAuthority operation returned by the service.
     * @throws ResourceNotFoundException
     *         A resource such as a private CA, S3 bucket, certificate, or audit report cannot be found.
     * @throws InvalidStateException
     *         The private CA is in a state during which a report or certificate cannot be generated.
     * @throws InvalidArnException
     *         The requested Amazon Resource Name (ARN) does not refer to an existing resource.
     * @sample AWSACMPCA.RestoreCertificateAuthority
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/acm-pca-2017-08-22/RestoreCertificateAuthority"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public RestoreCertificateAuthorityResult restoreCertificateAuthority(RestoreCertificateAuthorityRequest request) {
        request = beforeClientExecution(request);
        return executeRestoreCertificateAuthority(request);
    }

    @SdkInternalApi
    final RestoreCertificateAuthorityResult executeRestoreCertificateAuthority(RestoreCertificateAuthorityRequest restoreCertificateAuthorityRequest) {

        ExecutionContext executionContext = createExecutionContext(restoreCertificateAuthorityRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RestoreCertificateAuthorityRequest> request = null;
        Response<RestoreCertificateAuthorityResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RestoreCertificateAuthorityRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(restoreCertificateAuthorityRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "ACM PCA");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RestoreCertificateAuthority");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);

            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<RestoreCertificateAuthorityResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new RestoreCertificateAuthorityResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Revokes a certificate that was issued inside ACM Private CA. If you enable a certificate revocation list (CRL)
     * when you create or update your private CA, information about the revoked certificates will be included in the
     * CRL. ACM Private CA writes the CRL to an S3 bucket that you specify. For more information about revocation, see
     * the <a>CrlConfiguration</a> structure. ACM Private CA also writes revocation information to the audit report. For
     * more information, see <a>CreateCertificateAuthorityAuditReport</a>.
     * </p>
     * <note>
     * <p>
     * You cannot revoke a root CA self-signed certificate.
     * </p>
     * </note>
     * 
     * @param revokeCertificateRequest
     * @return Result of the RevokeCertificate operation returned by the service.
     * @throws ConcurrentModificationException
     *         A previous update to your private CA is still ongoing.
     * @throws InvalidArnException
     *         The requested Amazon Resource Name (ARN) does not refer to an existing resource.
     * @throws InvalidRequestException
     *         The request action cannot be performed or is prohibited.
     * @throws InvalidStateException
     *         The private CA is in a state during which a report or certificate cannot be generated.
     * @throws LimitExceededException
     *         An ACM Private CA limit has been exceeded. See the exception message returned to determine the limit that
     *         was exceeded.
     * @throws ResourceNotFoundException
     *         A resource such as a private CA, S3 bucket, certificate, or audit report cannot be found.
     * @throws RequestAlreadyProcessedException
     *         Your request has already been completed.
     * @throws RequestInProgressException
     *         Your request is already in progress.
     * @throws RequestFailedException
     *         The request has failed for an unspecified reason.
     * @sample AWSACMPCA.RevokeCertificate
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/acm-pca-2017-08-22/RevokeCertificate" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public RevokeCertificateResult revokeCertificate(RevokeCertificateRequest request) {
        request = beforeClientExecution(request);
        return executeRevokeCertificate(request);
    }

    @SdkInternalApi
    final RevokeCertificateResult executeRevokeCertificate(RevokeCertificateRequest revokeCertificateRequest) {

        ExecutionContext executionContext = createExecutionContext(revokeCertificateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RevokeCertificateRequest> request = null;
        Response<RevokeCertificateResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RevokeCertificateRequestProtocolMarshaller(protocolFactory).marshall(super.beforeMarshalling(revokeCertificateRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "ACM PCA");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RevokeCertificate");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);

            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<RevokeCertificateResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new RevokeCertificateResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Adds one or more tags to your private CA. Tags are labels that you can use to identify and organize your AWS
     * resources. Each tag consists of a key and an optional value. You specify the private CA on input by its Amazon
     * Resource Name (ARN). You specify the tag by using a key-value pair. You can apply a tag to just one private CA if
     * you want to identify a specific characteristic of that CA, or you can apply the same tag to multiple private CAs
     * if you want to filter for a common relationship among those CAs. To remove one or more tags, use the
     * <a>UntagCertificateAuthority</a> action. Call the <a>ListTags</a> action to see what tags are associated with
     * your CA.
     * </p>
     * 
     * @param tagCertificateAuthorityRequest
     * @return Result of the TagCertificateAuthority operation returned by the service.
     * @throws ResourceNotFoundException
     *         A resource such as a private CA, S3 bucket, certificate, or audit report cannot be found.
     * @throws InvalidArnException
     *         The requested Amazon Resource Name (ARN) does not refer to an existing resource.
     * @throws InvalidStateException
     *         The private CA is in a state during which a report or certificate cannot be generated.
     * @throws InvalidTagException
     *         The tag associated with the CA is not valid. The invalid argument is contained in the message field.
     * @throws TooManyTagsException
     *         You can associate up to 50 tags with a private CA. Exception information is contained in the exception
     *         message field.
     * @sample AWSACMPCA.TagCertificateAuthority
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/acm-pca-2017-08-22/TagCertificateAuthority"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public TagCertificateAuthorityResult tagCertificateAuthority(TagCertificateAuthorityRequest request) {
        request = beforeClientExecution(request);
        return executeTagCertificateAuthority(request);
    }

    @SdkInternalApi
    final TagCertificateAuthorityResult executeTagCertificateAuthority(TagCertificateAuthorityRequest tagCertificateAuthorityRequest) {

        ExecutionContext executionContext = createExecutionContext(tagCertificateAuthorityRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<TagCertificateAuthorityRequest> request = null;
        Response<TagCertificateAuthorityResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new TagCertificateAuthorityRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(tagCertificateAuthorityRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "ACM PCA");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "TagCertificateAuthority");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);

            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<TagCertificateAuthorityResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new TagCertificateAuthorityResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Remove one or more tags from your private CA. A tag consists of a key-value pair. If you do not specify the value
     * portion of the tag when calling this action, the tag will be removed regardless of value. If you specify a value,
     * the tag is removed only if it is associated with the specified value. To add tags to a private CA, use the
     * <a>TagCertificateAuthority</a>. Call the <a>ListTags</a> action to see what tags are associated with your CA.
     * </p>
     * 
     * @param untagCertificateAuthorityRequest
     * @return Result of the UntagCertificateAuthority operation returned by the service.
     * @throws ResourceNotFoundException
     *         A resource such as a private CA, S3 bucket, certificate, or audit report cannot be found.
     * @throws InvalidArnException
     *         The requested Amazon Resource Name (ARN) does not refer to an existing resource.
     * @throws InvalidStateException
     *         The private CA is in a state during which a report or certificate cannot be generated.
     * @throws InvalidTagException
     *         The tag associated with the CA is not valid. The invalid argument is contained in the message field.
     * @sample AWSACMPCA.UntagCertificateAuthority
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/acm-pca-2017-08-22/UntagCertificateAuthority"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public UntagCertificateAuthorityResult untagCertificateAuthority(UntagCertificateAuthorityRequest request) {
        request = beforeClientExecution(request);
        return executeUntagCertificateAuthority(request);
    }

    @SdkInternalApi
    final UntagCertificateAuthorityResult executeUntagCertificateAuthority(UntagCertificateAuthorityRequest untagCertificateAuthorityRequest) {

        ExecutionContext executionContext = createExecutionContext(untagCertificateAuthorityRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UntagCertificateAuthorityRequest> request = null;
        Response<UntagCertificateAuthorityResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UntagCertificateAuthorityRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(untagCertificateAuthorityRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "ACM PCA");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UntagCertificateAuthority");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);

            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<UntagCertificateAuthorityResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new UntagCertificateAuthorityResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Updates the status or configuration of a private certificate authority (CA). Your private CA must be in the
     * <code>ACTIVE</code> or <code>DISABLED</code> state before you can update it. You can disable a private CA that is
     * in the <code>ACTIVE</code> state or make a CA that is in the <code>DISABLED</code> state active again.
     * </p>
     * 
     * @param updateCertificateAuthorityRequest
     * @return Result of the UpdateCertificateAuthority operation returned by the service.
     * @throws ConcurrentModificationException
     *         A previous update to your private CA is still ongoing.
     * @throws ResourceNotFoundException
     *         A resource such as a private CA, S3 bucket, certificate, or audit report cannot be found.
     * @throws InvalidArgsException
     *         One or more of the specified arguments was not valid.
     * @throws InvalidArnException
     *         The requested Amazon Resource Name (ARN) does not refer to an existing resource.
     * @throws InvalidStateException
     *         The private CA is in a state during which a report or certificate cannot be generated.
     * @throws InvalidPolicyException
     *         The S3 bucket policy is not valid. The policy must give ACM Private CA rights to read from and write to
     *         the bucket and find the bucket location.
     * @sample AWSACMPCA.UpdateCertificateAuthority
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/acm-pca-2017-08-22/UpdateCertificateAuthority"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public UpdateCertificateAuthorityResult updateCertificateAuthority(UpdateCertificateAuthorityRequest request) {
        request = beforeClientExecution(request);
        return executeUpdateCertificateAuthority(request);
    }

    @SdkInternalApi
    final UpdateCertificateAuthorityResult executeUpdateCertificateAuthority(UpdateCertificateAuthorityRequest updateCertificateAuthorityRequest) {

        ExecutionContext executionContext = createExecutionContext(updateCertificateAuthorityRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateCertificateAuthorityRequest> request = null;
        Response<UpdateCertificateAuthorityResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateCertificateAuthorityRequestProtocolMarshaller(protocolFactory).marshall(super
                        .beforeMarshalling(updateCertificateAuthorityRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "ACM PCA");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateCertificateAuthority");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);

            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<UpdateCertificateAuthorityResult>> responseHandler = protocolFactory.createResponseHandler(
                    new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false),
                    new UpdateCertificateAuthorityResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Returns additional metadata for a previously executed successful, request, typically used for debugging issues
     * where a service isn't acting as expected. This data isn't considered part of the result data returned by an
     * operation, so it's available through this separate, diagnostic interface.
     * <p>
     * Response metadata is only cached for a limited period of time, so if you need to access this extra diagnostic
     * information for an executed request, you should use this method to retrieve it as soon as possible after
     * executing the request.
     *
     * @param request
     *        The originally executed request
     *
     * @return The response metadata for the specified request, or null if none is available.
     */
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
        return client.getResponseMetadataForRequest(request);
    }

    /**
     * Normal invoke with authentication. Credentials are required and may be overriden at the request level.
     **/
    private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler,
            ExecutionContext executionContext) {

        return invoke(request, responseHandler, executionContext, null, null);
    }

    /**
     * Normal invoke with authentication. Credentials are required and may be overriden at the request level.
     **/
    private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler,
            ExecutionContext executionContext, URI cachedEndpoint, URI uriFromEndpointTrait) {

        executionContext.setCredentialsProvider(CredentialUtils.getCredentialsProvider(request.getOriginalRequest(), awsCredentialsProvider));

        return doInvoke(request, responseHandler, executionContext, cachedEndpoint, uriFromEndpointTrait);
    }

    /**
     * Invoke with no authentication. Credentials are not required and any credentials set on the client or request will
     * be ignored for this operation.
     **/
    private <X, Y extends AmazonWebServiceRequest> Response<X> anonymousInvoke(Request<Y> request,
            HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler, ExecutionContext executionContext) {

        return doInvoke(request, responseHandler, executionContext, null, null);
    }

    /**
     * Invoke the request using the http client. Assumes credentials (or lack thereof) have been configured in the
     * ExecutionContext beforehand.
     **/
    private <X, Y extends AmazonWebServiceRequest> Response<X> doInvoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler,
            ExecutionContext executionContext, URI discoveredEndpoint, URI uriFromEndpointTrait) {

        if (discoveredEndpoint != null) {
            request.setEndpoint(discoveredEndpoint);
            request.getOriginalRequest().getRequestClientOptions().appendUserAgent("endpoint-discovery");
        } else if (uriFromEndpointTrait != null) {
            request.setEndpoint(uriFromEndpointTrait);
        } else {
            request.setEndpoint(endpoint);
        }

        request.setTimeOffset(timeOffset);

        HttpResponseHandler<AmazonServiceException> errorResponseHandler = protocolFactory.createErrorResponseHandler(new JsonErrorResponseMetadata());

        return client.execute(request, responseHandler, errorResponseHandler, executionContext);
    }

    @com.amazonaws.annotation.SdkInternalApi
    static com.amazonaws.protocol.json.SdkJsonProtocolFactory getProtocolFactory() {
        return protocolFactory;
    }

    @Override
    public AWSACMPCAWaiters waiters() {
        if (waiters == null) {
            synchronized (this) {
                if (waiters == null) {
                    waiters = new AWSACMPCAWaiters(this);
                }
            }
        }
        return waiters;
    }

    @Override
    public void shutdown() {
        super.shutdown();
        if (waiters != null) {
            waiters.shutdown();
        }
    }

}
