import { createContext } from "react";
import { User } from "../types";

interface AuthContext {
  user?: User | null;
  handleLogin: (userToken: string) => void;
  handleLogout: () => void;
}

export const AuthContext = createContext<AuthContext | undefined>(undefined);
