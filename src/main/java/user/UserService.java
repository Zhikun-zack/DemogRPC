package user;

import com.yrrhelp.grpc.User.APIResponse;
import com.yrrhelp.grpc.User.Empty;
import com.yrrhelp.grpc.User.LoginRequest;
import com.yrrhelp.grpc.userGrpc.userImplBase;

import io.grpc.stub.StreamObserver;

public class UserService extends  userImplBase{

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
	    System.out.println("Inside login");

	    String username = request.getUsername();
	    String password = request.getPassword();

	    APIResponse.Builder response = APIResponse.newBuilder();
	    if(username.equals(password)){
	    	// return success message
			response.setResponseCode(0).setResponsemessage("SUCCESS");
		}else{
	    	// return failure message
			response.setResponseCode(100).setResponsemessage("INVALID");
		}

	    responseObserver.onNext(response.build()); // Send response message back to client
	    responseObserver.onCompleted(); // Close the service
	}

	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
	    
	}
	
}
