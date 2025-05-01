import img from "@/assets/image.webp";
import plus from "@/assets/plus.svg";
import playArrow from "@/assets/playArrow.svg";

interface ThemeCardProps {
  title: string;
  description: string;
  date: Date;
  time: string;
}

const ThemeCard = ({ title, description, date, time }: ThemeCardProps) => {
  return (
    <div className="flex min-w-[360px] items-start gap-4">
      <img src={img} alt="imgTheme" />
      <div className="flex flex-col items-start justify-between self-stretch">
        <div>
          <h2 className="text-left text-xl text-[#1D1B20]">{title}</h2>
          <p className="text-[#49454F]">{description}</p>
        </div>
        <div className="flex items-center justify-between self-stretch">
          <div className="flex h-6 items-center gap-1">
            <img src={plus} alt="plusIcon" />
            <span>{date.toLocaleDateString()}</span>
            <span>•</span>
            <span>{time}</span>
          </div>
          <img src={playArrow} alt="playArrow" />
        </div>
      </div>
    </div>
  );
};

export default ThemeCard;
