package com.example.graphql.publisher;

import org.springframework.stereotype.Component;

import com.example.graphql.domain.Transaction;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.observables.ConnectableObservable;

@Component
public class TransactionPublisher {

	private final Flowable<Transaction> publisher;

	private ObservableEmitter<Transaction> emitter;

	public TransactionPublisher() {
		Observable<Transaction> transactionObservable = Observable.create(emitter -> {
			this.emitter = emitter;
		});
		ConnectableObservable<Transaction> connectableObservable = transactionObservable.share().publish();
		connectableObservable.connect();
		publisher = connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
	}

	public void publish(final Transaction transaction) {
		emitter.onNext(transaction);
	}

	public Flowable<Transaction> getPublisher() {
		return publisher.map((transaction) -> new Transaction(transaction.getAccountNumber(),
				transaction.getTransactionId(), transaction.getTransactionDate(),
				transaction.getTransactionDescription(), transaction.getMerchantName()));
	}
}
