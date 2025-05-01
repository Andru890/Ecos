import { Outlet } from "react-router";
import { Header } from "../Header.tsx";
import { Footer } from "../Footer.tsx";

export const MainLayout = () => {
  return (
    <div className="grid min-h-dvh grid-rows-[auto_1fr_auto]">
      <Header />
      <Outlet />
      <Footer />
    </div>
  );
};
