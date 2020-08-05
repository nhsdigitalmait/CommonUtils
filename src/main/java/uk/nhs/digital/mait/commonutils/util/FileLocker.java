/*
 Copyright 2012  Damian Murphy <murff@warlock.org>

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
// $Id: FileLocker.java 22 2017-12-13 11:20:59Z sfarrow $

package uk.nhs.digital.mait.commonutils.util;

import java.io.File;
import static java.util.logging.Level.WARNING;

/**
 * Added file locking for log files to ensure that the writing thread in the OS
 * is fully disengaged before other threads attempt a read. This is a
 * discretionary lock ie you don't *have* to check it and there's nothing to
 * stop you opening the file if its been previously locked.
 *
 * @author riro
 */
public class FileLocker implements AutoCloseable {

    private final String fileToLock;
    private static final String LOCK_EXTENSION = ".lck";
    private final static boolean DEBUG = false;

    /**
     * public constructor locks the file even if it doesn't exist yet. This is a
     * one shot object ie once you have unlocked it if you want to relock you
     * will need to allocate a new object.
     *
     * @param fileToLock
     * @throws Exception
     */
    public FileLocker(String fileToLock) throws Exception {
        this.fileToLock = fileToLock;
        lock();
    }

    private void lock()
            throws Exception {
        if (DEBUG) {
            System.out.println("Locking file " + fileToLock);
        }

        File f = new File(fileToLock.concat(LOCK_EXTENSION));
        if (!f.exists()) {
            f.createNewFile();
        } else {
            Logger.getInstance().log(WARNING,FileLocker.class.getName(),"trying to lock a file which is already locked " + fileToLock);
        }

        // we could do this but there's a good argument for saying that prelocking a file you know will
        // shortly exist is a perfectly sensible thing to do.
//      if (!new File(fileToLock).exists()) {
//          System.err.println("FileLocker: Warning locked a non existent file " + fileToLock);
//      }
    }

    /**
     * unlock the file associated with this lock
     *
     * @throws Exception
     */
    public void unlock()
            throws Exception {
        if (DEBUG) {
            System.out.println("Unlocking file " + fileToLock);
        }
        File f = new File(fileToLock.concat(LOCK_EXTENSION));
        if (new File(fileToLock).exists()) {
            if (f.exists()) {
                f.delete();
            } else {
                Logger.getInstance().log(WARNING,FileLocker.class.getName(),"trying to unlock a file which is not locked " + fileToLock);
            }
        } else {
            Logger.getInstance().log(WARNING,FileLocker.class.getName(),"trying to unlock a non existent file " + fileToLock);
        }
    }

    /**
     * check whether the file at this path is currently locked or not
     *
     * @param fileToCheck path to the file to check
     * @return whether the file is locked or not
     * @throws Exception
     */
    public static boolean hasLock(String fileToCheck)
            throws Exception {
        boolean result = new File(fileToCheck.concat(LOCK_EXTENSION)).exists();
        if (DEBUG) {
            System.out.println("hasLock check on " + fileToCheck + " returning " + result);
        }
        return result;
    }

    @Override
    /**
     * unlocks the file associated with the lock, allows use with try with
     * resources
     */
    public void close() throws Exception {
        if (DEBUG) {
            System.out.println("Unlock called from close for file " + fileToLock);
        }
        unlock();
    }
}
