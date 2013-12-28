package com.vteba.cache.memcached.transaction;

import com.vteba.cache.memcached.Element;

/**
 * A soft lock is used to lock elements in transactional stores
 * 
 * @author Ludovic Orban
 */
public interface SoftLock {

    /**
     * Get the key of the element this soft lock is guarding
     * @return the key
     */
    String getKey();

    /**
     * Get the element the current transaction is supposed to see.
     * @param currentTransactionId the current transaction under which this call is executed
     * @param softLockId the soft lock ID
     * @return the Element visible to the current transaction
     */
    Element getElement(TransactionID currentTransactionId, SoftLockID softLockId);

    /**
     * Lock the soft lock
     */
    void lock();

    /**
     * Attempt to lock the soft lock
     * @param ms the time in milliseconds before this method gives up
     * @return true if the soft lock was locked, false otherwise
     * @throws InterruptedException if the thread calling this method was interrupted
     */
    boolean tryLock(long ms) throws InterruptedException;

    /**
     * Clear the state of the soft lock after a tryLock() call succeeded.
     */
    void clearTryLock();

    /**
     * Unlock the soft lock. Once a soft lock got unlocked, it is considered 'dead': it cannot be
     * locked again and must be cleaned up
     */
    void unlock();

    /**
     * Freeze the soft lock. A soft lock should only be frozen for a very short period of time as this blocks
     * the {@link #getElement(TransactionID, SoftLockID)} method calls.
     * Freeze is used to mark the start of a commit / rollback phase
     */
    void freeze();

    /**
     * Unfreeze the soft lock
     */
    void unfreeze();

    /**
     * Check if the soft lock expired, ie: that the thread which locked it died
     * @return true if the soft lock is orphan and should be cleaned up, false otherwise
     */
    boolean isExpired();


}
