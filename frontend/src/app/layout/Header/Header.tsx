import { useEffect, useState } from "react";
import { Link } from "react-router";
import { Avatar } from "@/auth/components/ui/Avatar";
import Input from "@/app/ui/Input";
import AuthModal, { AuthMode } from "@/auth/components/AuthModal";
import MenuIcon from "@/assets/hamburgerMenu.svg?react";
import Lens from "@/assets/lens.svg?react";
import { useAuth } from "@/auth/hooks/use-auth";
import UserMenu from "@/auth/components/UserMenu";
import { Bell } from "./Bell";

export const Header = () => {
  const [openModal, setOpenModal] = useState<AuthMode | null>(null);
  const [isOpen, setIsOpen] = useState(false);

  const { user } = useAuth();

  const handleOpenModal = (mode: AuthMode) => {
    setOpenModal(mode);
  };

  const handleCloseModal = () => {
    setOpenModal(null);
  };

  const toggleMenu = () => {
    setIsOpen(!isOpen);
  };

  const closeMenu = () => {
    setIsOpen(false);
  };

  useEffect(() => {
    if (user) setOpenModal(null);
  }, [user]);

  return (
    <>
      <header className="w-full bg-[#B1B1B1] shadow">
        {/* Contenedor interno para centrar el contenido */}
        <div className="mx-auto flex items-center justify-between px-12 py-6">
          <div className="flex items-center gap-16">
            <Link to="/" className="hidden px-6 py-5 lg:flex">
              <p className="text-4xl font-bold">LOGO</p>
            </Link>
            <button
              type="button"
              className="block p-2 focus:outline-none lg:hidden"
              onClick={toggleMenu}
            >
              Menu
              <MenuIcon />
            </button>
            {isOpen && (
              <nav className="absolute top-18 left-0 w-48 bg-white p-4 shadow-md md:hidden">
                <Link to="/explorer" className="block py-2" onClick={closeMenu}>
                  Explorar
                </Link>
                <Link to="/artist" className="block py-2" onClick={closeMenu}>
                  Artistas
                </Link>
                <Link to="/play" className="block py-2" onClick={closeMenu}>
                  Play
                </Link>
              </nav>
            )}
            <nav className="hidden gap-6 text-xl font-semibold lg:flex xl:gap-16">
              <Link to="/explorer">Explorar</Link>
              <Link to="/artist">Artistas</Link>
              <Link to="/play">Play</Link>
            </nav>
          </div>
          <div className="flex items-center gap-6">
            {!user ? (
              <>
                <div className="hidden gap-6 text-xl font-semibold sm:flex xl:mx-24 xl:gap-12">
                  <button
                    className="cursor-pointer"
                    type="button"
                    onClick={() => {
                      handleOpenModal("login");
                    }}
                  >
                    Iniciar Sesión
                  </button>
                  <button
                    className="cursor-pointer"
                    type="button"
                    onClick={() => {
                      handleOpenModal("register");
                    }}
                  >
                    Crear cuenta
                  </button>
                </div>
                <Avatar />
              </>
            ) : (
              <>
                <Bell />
                <UserMenu />
              </>
            )}
          </div>
        </div>
        <div className="container mx-auto w-full px-4 pb-6">
          <Input
            placeholder="Busca Artista, Album, Canción"
            className="mx-auto flex w-full bg-[#ECE6F0] sm:w-4/5"
            startIcon={<MenuIcon />}
            endIcon={<Lens />}
          />
        </div>
      </header>
      {openModal && <AuthModal mode={openModal} onClose={handleCloseModal} />}
    </>
  );
};
