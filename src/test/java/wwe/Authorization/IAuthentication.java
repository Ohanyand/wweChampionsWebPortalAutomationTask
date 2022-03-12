package wwe.Authorization;

import wwe.model.IMainUser;

public interface IAuthentication {
   public IMainUser logIn(String username, String password) throws InterruptedException;
}