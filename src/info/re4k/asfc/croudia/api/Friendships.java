package info.re4k.asfc.croudia.api;

import info.re4k.asfc.croudia.CroudiaException;
import info.re4k.asfc.croudia.Friendship;
import info.re4k.asfc.croudia.Relationship;
import info.re4k.asfc.croudia.ResponseList;
import info.re4k.asfc.croudia.User;
import info.re4k.asfc.croudia.param.RelationshipParam;
import info.re4k.asfc.croudia.param.UserMultiParam;
import info.re4k.asfc.croudia.param.UserParam;

public interface Friendships{
	User createFriend(UserParam p) throws CroudiaException;

	User destroyFriend(UserParam p) throws CroudiaException;

	Relationship showFriend(RelationshipParam p) throws CroudiaException;

	ResponseList<Friendship,UserMultiParam> lookupFriend(UserMultiParam p) throws CroudiaException;
}
