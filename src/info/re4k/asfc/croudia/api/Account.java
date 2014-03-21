package info.re4k.asfc.croudia.api;

import info.re4k.asfc.croudia.CroudiaException;
import info.re4k.asfc.croudia.User;
import info.re4k.asfc.croudia.param.AccountProfileParam;

public interface Account{
	public User getVerifyCredentials() throws CroudiaException;

	public User updateProfile(AccountProfileParam p) throws CroudiaException;
}
