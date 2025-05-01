import img from "@/assets/image.webp";
import Button from "../Button";

interface EventCardProps {
  headline: string;
  supportingText: string;
  datePublished: Date;
  contentPublished: string;
}

const EventCard = ({
  headline,
  supportingText,
  datePublished,
  contentPublished,
}: EventCardProps) => {
  return (
    <div className="flex max-w-[462px] min-w-[337px] flex-col items-start justify-end bg-[#FEF7FF] pr-4 pl-4">
      <div className="flex items-start gap-6 py-4">
        <img src={img} alt="imagen" className="h-auto min-w-[159px] rounded-[28px]" />
        <div className="flex flex-col items-start gap-6">
          <div className="flex flex-col items-start gap-1">
            <h2 className="text-xl text-[#1D1B20]">{headline}</h2>
            <h4 className="font-medium text-[#49454F]">{supportingText}</h4>
          </div>
          <Button className="gap-2 bg-[#6E6E6E] px-[24px] py-[10px] text-white"> Download </Button>
        </div>
      </div>
      <div className="flex flex-col items-start gap-2 py-2">
        <h5 className="font-medium text-[#49454F]">{datePublished.toLocaleDateString()}</h5>
        <p className="text-left text-[#1D1B20]">{contentPublished}</p>
      </div>
    </div>
  );
};

export default EventCard;
