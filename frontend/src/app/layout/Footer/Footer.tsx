import { Link } from "react-router";
import Button from "@/app/ui/Button";
import tikTok from "@/assets/tikTok.webp";
import instagram from "@/assets/instagram.webp";
import youtube from "@/assets/youtube.webp";
import facebook from "@/assets/facebook.webp";

const SocialLinks = () => (
  <div className="flex w-full items-center gap-2">
    <a href="" target="_blank" rel="noopener noreferrer" className="max-h-12 max-w-12">
      <img src={youtube} alt="Youtube" />
    </a>
    <a href="" target="_blank" rel="noopener noreferrer" className="max-h-12 max-w-12">
      <img src={instagram} alt="Instagram" />
    </a>
    <a href="" target="_blank" rel="noopener noreferrer" className="max-h-12 max-w-12">
      <img src={tikTok} alt="TikTok" />
    </a>
    <a href="" target="_blank" rel="noopener noreferrer" className="max-h-12 max-w-12">
      <img src={facebook} alt="Facebook" />
    </a>
  </div>
);

export const Footer = () => {
  return (
    <footer className="mt-6 flex flex-col items-center sm:mx-8 sm:items-start">
      <div className="flex flex-col items-start gap-18 md:inline-flex lg:mx-auto lg:flex-row">
        <div className="flex flex-col items-start gap-6">
          <h3 className="text-xl font-medium">NOSOTROS</h3>
          <Link to="/" className="border-b">
            bienvenidos
          </Link>
          <Link to="/explorer" className="border-b">
            explorar
          </Link>
          <Link to="/artist" className="border-b">
            artista
          </Link>
          <Link to="/play" className="border-b">
            play
          </Link>
        </div>
        <div className="flex flex-col items-start gap-8">
          <h3 className="text-xl font-medium">ACERCA DE</h3>
          <Link to="/ayuda" className="border-b">
            ayuda
          </Link>
          <Link to="/prensa" className="border-b">
            prensa
          </Link>
          <Link to="/politicaDeUso" className="border-b">
            politica de uso
          </Link>
        </div>
        <div className="flex flex-col items-start gap-8">
          <h3 className="text-xl font-medium">¿ERES ORGANIZADOR/PROMOTOR?</h3>
          <Button className="max-w-72 bg-[#6E6E6E] text-white">CREAR EVENTO</Button>
        </div>
        <div className="flex flex-col items-start gap-8">
          <h3 className="text-xl font-medium">SEGUINOS</h3>
          <SocialLinks />
        </div>
      </div>
      <span className="mx-auto mt-16 mb-6">
        Copyright © 2025 ECOS - Todos los derechos reservados.
      </span>
    </footer>
  );
};
