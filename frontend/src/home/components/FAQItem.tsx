import ArrowUpIcon from "./ui/ArrowUpIcon";

const FAQItemList = [
  {
    id: 1,
    question: "¿Cómo puedo promocionar mi música en esta plataforma?",
    answer:
      "Sube tus canciones, completa tu perfil con biografía y fotos, usa etiquetas (#género #ubicación) y participa en playlists destacadas.",
  },
  {
    id: 2,
    question: "¿Puedo recibir donaciones de mis fans?",
    answer:
      "Sí, activa la opción 'Donaciones' en tu perfil. Los fans pueden apoyarte económicamente y tú recibes el 100% (menos comisión de la plataforma).",
  },
  {
    id: 3,
    question: "¿Cómo contrato a un artista para mi evento?",
    answer:
      "Busca artistas por género o ubicación, revisa sus perfiles y envía una solicitud directa. Si aceptan, podrás gestionar fechas y pagos desde la plataforma.",
  },
  {
    id: 4,
    question: "¿Puedo vender entradas para mi evento aquí?",
    answer:
      "Sí, crea tu evento, configura precios y aforo, y puedes promocionarlo entre los usuarios.",
  },
  {
    id: 5,
    question: "¿Cómo apoyo a mis artistas favoritos?",
    answer:
      "Puedes dar like, compartir su música, asistir a sus eventos y enviar donaciones directas desde su perfil.",
  },
];

const FAQItem = () => {
  return (
    <li className="w-96 list-none border-b-1 border-black sm:w-128 lg:w-3/5">
      {FAQItemList.map(({ id, question, answer }) => (
        <div key={id} className="border-t-1 border-black">
          <div className="flex justify-between py-[20px]">
            <h3 className="text-lg">{question}</h3>
            <ArrowUpIcon />
          </div>
          <p className="pb-[24px] text-sm">{answer}</p>
        </div>
      ))}
    </li>
  );
};

export default FAQItem;
