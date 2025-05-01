import Button from "../Button";

interface StackedCardProps {
  titleHeader: string;
  subtitleHeader: string;
  titleContent: string;
  subtitleContent: string;
  media: string;
  avatar: string;
  description: string;
}

const StackedCard = ({
  titleHeader,
  subtitleHeader,
  titleContent,
  subtitleContent,
  media,
  avatar,
  description,
}: StackedCardProps) => {
  return (
    <div className="flex max-w-lg min-w-[360px] flex-1 basis-0 flex-col items-start rounded-xl border border-[#B1B1B1]">
      <header className="flex gap-4 pt-3 pr-1 pb-3 pl-4">
        <img src={avatar} alt="Avatar" />
        <div className="flex w-full flex-col items-start gap-1">
          <h3 className="font-medium">{titleHeader}</h3>
          <h4>{subtitleHeader}</h4>
        </div>
      </header>
      <img src={media} alt="Media" />
      <div className="flex flex-col items-start gap-8 p-4">
        <div className="flex flex-col items-start">
          <h3>{titleContent}</h3>
          <h3>{subtitleContent}</h3>
        </div>
        <p className="text-left">{description}</p>
        <div className="flex items-start justify-end gap-2 self-end">
          <Button className="gap-2 bg-white px-6 py-[10px] font-medium text-[#6E6E6E]">
            Enabled
          </Button>
          <Button className="gap-2 bg-[#6E6E6E] px-6 py-[10px] font-medium text-white">
            Enabled
          </Button>
        </div>
      </div>
    </div>
  );
};

export default StackedCard;
