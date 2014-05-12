package info.re4k.asfc.croudia;

public interface SecretMail{
	/**
	 * @return 送信した日時
	 */
	public long getCreatedAt();

	/**
	 * @return id
	 */
	public long getId();

	/**
	 * @return 本文
	 */
	public String getText();

	/**
	 * @return 受信者
	 */
	public User getRecipientUser();

	/**
	 * @return 受信者のuser id
	 */
	public long getRecipientId();

	/**
	 * @return 受信者のスクリーンネーム
	 */
	public String getRecipientScreenName();

	/**
	 * @return 送信者
	 */
	public User getSenderUser();

	/**
	 * @return 送信者のuser id
	 */
	public long getSenderId();

	/**
	 * @return 送信者のスクリーンネーム
	 */
	public String getSenderScreenName();

	public MediaEntity getMediaEntity();

}
