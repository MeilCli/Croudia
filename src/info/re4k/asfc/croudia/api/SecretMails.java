package info.re4k.asfc.croudia.api;

import info.re4k.asfc.croudia.CroudiaException;
import info.re4k.asfc.croudia.ResponseList;
import info.re4k.asfc.croudia.SecretMail;
import info.re4k.asfc.croudia.param.SecretPageParam;
import info.re4k.asfc.croudia.param.SecretMailNewParam;

public interface SecretMails{
	public ResponseList<SecretMail,SecretPageParam> getSecretMail(SecretPageParam p) throws CroudiaException;

	public ResponseList<SecretMail,SecretPageParam> getSentSecretMail(SecretPageParam p) throws CroudiaException;

	public SecretMail newSecretMail(SecretMailNewParam p) throws CroudiaException;
	
	public SecretMail destroySecretMail(long id) throws CroudiaException;
	
	public SecretMail showSecretMail(long id) throws CroudiaException;
}
