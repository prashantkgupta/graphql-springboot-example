package com.example.graphql.publisher;

import org.springframework.stereotype.Component;

import com.example.graphql.domain.Account;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.observables.ConnectableObservable;

@Component
public class AccountPublisher {

	private final Flowable<Account> publisher;

	private ObservableEmitter<Account> emitter;

	public AccountPublisher() {
		Observable<Account> accounteObservable = Observable.create(emitter -> {
			this.emitter = emitter;
		});
		ConnectableObservable<Account> connectableObservable = accounteObservable.share().publish();
		connectableObservable.connect();
		publisher = connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
	}

	public void publish(final Account account) {
		emitter.onNext(account);
	}

	public Flowable<Account> getPublisher() {
		return publisher.map((source) -> new Account(source.getAccountNumber(), source.getAccountName(),
				source.getAccountBalance(), source.getAccountType()));
	}
}
