import OptionsRegisterCards from "@/shared/components/Cards/OptionsRegisterCards";
import avatar from "@/assets/avatar.svg";
import media from "@/assets/media.webp";

export default function OptionsRegister() {
  const cardsData = [
    {
      id: "musicos",
      icono: avatar,
      option: "MÚSICOS",
      description: "**Artistas independientes y emergentes**",
      imageSrc: media,
      title: "Conquista tu escena musical",
      subtitle: "Plataforma diseñada para impulsar tu carrera",
      parrafo: "Promociona tu música, encuentra oportunidades y conecta con tu audiencia.",
      buttonText: "Regístrate",
    },
    {
      id: "organizadores",
      icono: avatar,
      option: "ORGANIZADOR",
      description: "**Descubre y contrata el mejor talento musical**",
      imageSrc: media,
      title: "Crea eventos inolvidables",
      subtitle: "Conecta con músicos ideales para tu público",
      parrafo: "Encuentra talento, gestiona eventos y llena tus espacios con la mejor música.",
      buttonText: "Regístrate",
    },
    {
      id: "eventos",
      icono: avatar,
      option: "PRÓXIMOS EVENTOS",
      description: "Subhead",
      imageSrc: media,
      title: "title",
      subtitle: "subtitle",
      parrafo: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",
      buttonText: "Explorar",
    },
  ];

  return (
    <div className="mx-auto mt-12 w-auto text-center">
      <div className="mx-12 w-5/6 text-start text-3xl md:mx-24 md:w-158">
        <h2 className="text-4xl font-normal md:text-[40px]">
          Conectamos músicos, fans y eventos en una sola plataforma
        </h2>
        <h2 className="mt-12 text-[32px] font-bold md:text-[40px]">¡Empieza!</h2>
      </div>
      <div className="mt-32 flex w-full flex-col gap-6 lg:flex-row lg:px-12">
        {cardsData.map((data) => (
          <OptionsRegisterCards key={data.id} {...data} />
        ))}
      </div>
    </div>
  );
}
