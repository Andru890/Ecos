import { useState, useEffect, useMemo, PropsWithChildren } from "react";
import { jwtDecode } from "jwt-decode";
import { AuthContext } from "./auth-context";
import { User } from "../types";

type AuthProviderProps = PropsWithChildren;

export const AuthProvider = ({ children }: AuthProviderProps) => {
  const [user, setUser] = useState<User | null>();

  const handleLogin = (userToken: string) => {
    localStorage.setItem("userToken", userToken);

    const userData = jwtDecode<User>(userToken);
    setUser(userData);
  };

  const handleLogout = () => {
    setUser(null);
    localStorage.removeItem("userToken");
  };

  useEffect(() => {
    const storedToken = localStorage.getItem("userToken");

    if (storedToken) setUser(jwtDecode<User>(storedToken));
  }, []);

  const value = useMemo(() => ({ user, handleLogin, handleLogout }), [user]);

  return <AuthContext value={value}>{children}</AuthContext>;
};
