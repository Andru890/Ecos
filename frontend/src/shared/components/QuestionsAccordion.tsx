import { useState } from "react";
import arrow from "@/assets/arrow.svg";

interface QuestionsProps {
  title: string;
  content: string;
}

const QuestionsAccordion = ({ title, content }: QuestionsProps) => {
  const [isOpen, setIsOpen] = useState(false);

  return (
    <div className="w-full">
      <div className="flex items-center justify-between gap-6 self-stretch border-t border-black p-4">
        <span className="font-bold">{title}</span>
        <img
          src={arrow}
          alt="Desplegar"
          onClick={() => {
            setIsOpen(!isOpen);
          }}
          className={`cursor-pointer transition-transform duration-300 ${isOpen ? "rotate-0" : "rotate-180"}`}
        />
      </div>
      <div
        className={`flex items-start gap-4 self-stretch overflow-hidden pb-6 transition-all duration-300 ${
          isOpen ? "max-h-96 opacity-100" : "max-h-0 opacity-0"
        }`}
      >
        <p className="text-left">{content}</p>
      </div>
    </div>
  );
};

export default QuestionsAccordion;
