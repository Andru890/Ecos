import Button from "../Button";
import img from "@/assets/image.webp";

interface FeaturedArtistCardProps {
  headline: string;
  datePublished: Date;
  contentPublished: string;
}

const FeaturedArtistCard = ({
  headline,
  datePublished,
  contentPublished,
}: FeaturedArtistCardProps) => {
  return (
    <div className="flex max-w-[654px] min-w-[328px] items-start gap-6 px-6 py-2">
      <img src={img} alt="img" className="h-auto w-[216px] rounded-3xl" />
      <div className="flex shrink flex-col items-start gap-6">
        <div className="flex flex-col items-start gap-1">
          <h2 className="text-xl text-[#1D1B20]">{headline}</h2>
          <h5 className="font-medium text-[#49454F]">{datePublished.toLocaleDateString()}</h5>
          <p className="text-left text-sm text-[#1D1B20]">{contentPublished}</p>
        </div>
        <Button className="w-max gap-2 bg-[#6E6E6E] px-[24px] py-[10px] text-white">
          Download
        </Button>
      </div>
    </div>
  );
};

export default FeaturedArtistCard;
