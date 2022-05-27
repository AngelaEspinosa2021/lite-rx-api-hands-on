package io.pivotal.literx;

import io.pivotal.literx.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * Learn how to transform values.
 *
 * @author Sebastien Deleuze
 */
public class Part04Transform {

//========================================================================================

	// TODO Capitalize the user username, firstname and lastname
	Mono<User> capitalizeOne(Mono<User> mono) {
		return Mono.just(new User(User.SKYLER.getUsername().toUpperCase(), User.SKYLER.getFirstname().toUpperCase(), User.SKYLER.getLastname().toUpperCase()));

		/*Mono.just(user).

				.map(item -> {
			item.getUsername().toUpperCase();
			item.getFirstname().toUpperCase();
			item.getLastname().toUpperCase();
			return item;
		}).subscribe(p ->p.toString());
		return Mono.just(user).map(
		});*/
	}

//========================================================================================

	// TODO Capitalize the users username, firstName and lastName
	Flux<User> capitalizeMany(Flux<User> flux) {
		List<User> usuarios = new ArrayList<>();
		usuarios.add(new User(User.SKYLER.getUsername().toUpperCase(), User.SKYLER.getFirstname().toUpperCase(), User.SKYLER.getLastname().toUpperCase()));
		usuarios.add(new User(User.JESSE.getUsername().toUpperCase(), User.JESSE.getFirstname().toUpperCase(), User.JESSE.getLastname().toUpperCase()));
		usuarios.add(new User(User.WALTER.getUsername().toUpperCase(), User.WALTER.getFirstname().toUpperCase(), User.WALTER.getLastname().toUpperCase()));
		usuarios.add(new User(User.SAUL.getUsername().toUpperCase(), User.SAUL.getFirstname().toUpperCase(), User.SAUL.getLastname().toUpperCase()));

		return Flux.fromIterable(usuarios);
	}

//========================================================================================

	// TODO Capitalize the users username, firstName and lastName using #asyncCapitalizeUser
	Flux<User> asyncCapitalizeMany(Flux<User> flux) {
		return null;
	}

	Mono<User> asyncCapitalizeUser(User u) {
		return Mono.just(new User(u.getUsername().toUpperCase(), u.getFirstname().toUpperCase(), u.getLastname().toUpperCase()));
	}

}
