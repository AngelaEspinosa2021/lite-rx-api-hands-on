package io.pivotal.literx;

import io.pivotal.literx.domain.User;
import io.pivotal.literx.repository.ReactiveRepository;
import io.pivotal.literx.repository.ReactiveUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static io.pivotal.literx.domain.User.*;


/**
 * Learn how to control the demand.
 *
 * @author Sebastien Deleuze
 */
public class Part06Request {

	private static final Logger log = LoggerFactory.getLogger(Part06Request.class);
	ReactiveRepository<User> repository = new ReactiveUserRepository();

//========================================================================================

	// TODO Create a StepVerifier that initially requests all values and expect 4 values to be received
	StepVerifier requestAllExpectFour(Flux<User> flux) {

		return StepVerifier.create(flux).expectNextCount(4).expectComplete();
	}

//========================================================================================

	// TODO Create a StepVerifier that initially requests 1 value and expects User.SKYLER then requests another value and expects User.JESSE then stops verifying by cancelling the source
	StepVerifier requestOneExpectSkylerThenRequestOneExpectJesse(Flux<User> flux) {

		return StepVerifier.create(flux).expectNext(SKYLER).expectNext(JESSE).thenCancel();
	}

//========================================================================================

	// TODO Return a Flux with all users stored in the repository that prints automatically logs for all Reactive Streams signals
	Flux<User> fluxWithLog() {

		List<User> usuarios = new ArrayList<>();
		usuarios.add(new User(User.SKYLER.getUsername(), User.SKYLER.getFirstname(), User.SKYLER.getLastname()));
		usuarios.add(new User(User.JESSE.getUsername(), User.JESSE.getFirstname(), User.JESSE.getLastname()));
		usuarios.add(new User(User.WALTER.getUsername(), User.WALTER.getFirstname(), User.WALTER.getLastname()));
		usuarios.add(new User(User.SAUL.getUsername(), User.SAUL.getFirstname(), User.SAUL.getLastname()));

		Flux<User> flux = Flux.just(new User(User.SKYLER.getUsername(), User.SKYLER.getFirstname(), User.SKYLER.getLastname()),
				new User(User.JESSE.getUsername(), User.JESSE.getFirstname(), User.JESSE.getLastname()),
				new User(User.WALTER.getUsername(), User.WALTER.getFirstname(), User.WALTER.getLastname()),
				new User(User.SAUL.getUsername(), User.SAUL.getFirstname(), User.SAUL.getLastname()));
		flux.collectList().subscribe(x -> log.info(x.toString()));
		return flux;
	}

//========================================================================================

	// TODO Return a Flux with all users stored in the repository that prints "Starring:" on subscribe, "firstname lastname" for all values and "The end!" on complete
	Flux<User> fluxWithDoOnPrintln() {
		return null;
	}

}
