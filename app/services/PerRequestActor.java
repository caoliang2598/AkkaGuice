package services;
import play.Logger;
import akka.actor.UntypedActor;
import akkaGuice.annotations.RegisterActor;

import com.google.inject.Inject;

@RegisterActor("PerRequest")
public class PerRequestActor extends UntypedActor {
	private final SayHello hello;
	
	@Inject
	public PerRequestActor(SayHello hello) {
		this.hello = hello;
	}
	
	@Override
	public void onReceive(Object arg0) throws Exception {
		Logger.info("Hello from per request actor: " + getSelf());
		hello.hello(getSelf().toString());
	}
}