package info.re4k.asfc.croudia;

public interface Status{
	/**
	 * @return ささやいた日時
	 */
	public long getCreatedAt();

	/**
	 * @return お気に入りに登録されているかどうか
	 */
	public boolean isFavorited();

	/**
	 * @return スプレッドしたかどうか
	 */
	public boolean isSpread();

	/**
	 * @return スプレッドされた数
	 */
	public int getSpreadCount();

	/**
	 * @return お気に入りに登録されている数
	 */
	public int getFavoritedCount();

	/**
	 * @return id
	 */
	public long getId();

	/**
	 * @return 本文
	 */
	public String getText();

	/**
	 * @return ささやいたクライアント情報
	 */
	public Source getSource();

	/**
	 * @return ささやいたユーザー
	 */
	public User getUser();

	/**
	 * @return 返信先のユーザーのスクリーンネーム
	 */
	public String getInReplyToScreenName();

	/**
	 * @return 返信先のstatus id
	 */
	public long getInReplyToStatusId();

	/**
	 * @return 返信先のuser id
	 */
	public long getInReplyToUserId();

	/**
	 * @return スプレッドした元のstatus
	 */
	public Status getSpreadStatus();

	/**
	 * @return 引用返信時に引用された元のstatus
	 */
	public Status getReplyStatus();

}
