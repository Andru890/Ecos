import { PlayIcon } from "@/home/components/ui/PlayIcon";
import { PlusCircle } from "@/home/components/ui/PlusCircle";
import image from "@/assets/image.webp";

const FAVORITE_LIST = [
  {
    id: 1,
    image: image,
    title: "Title",
    description: "Description duis aute irure dolor in reprehenderit in voluptate velit.",
    icon1: <PlusCircle className="stroke-[#1D1B20]" />,
    date: "Today",
    time: "23 min",
    icon2: <PlayIcon className="fill-[#1D1B20] stroke-0" />,
  },
  {
    id: 2,
    image: image,
    title: "Title",
    description: "Description duis aute irure dolor in reprehenderit in voluptate velit.",
    icon1: <PlusCircle className="stroke-[#1D1B20]" />,
    date: "Today",
    time: "23 min",
    icon2: <PlayIcon className="fill-[#1D1B20] stroke-0" />,
  },
  {
    id: 3,
    image: image,
    title: "Title",
    description: "Description duis aute irure dolor in reprehenderit in voluptate velit.",
    icon1: <PlusCircle className="stroke-[#1D1B20]" />,
    date: "Today",
    time: "23 min",
    icon2: <PlayIcon className="fill-[#1D1B20] stroke-0" />,
  },
];

const CardTopicsList = () => {
  return (
    <div className="space-y-4">
      {FAVORITE_LIST.map(({ id, image, title, description, icon1, date, time, icon2 }) => (
        <div key={id} className="flex w-full gap-4 rounded-lg p-2">
          <img src={image} alt="image" className="h-21 w-21 rounded-xl" />
          <div className="flex flex-col">
            <header>
              <h3 className="text-start text-sm font-semibold">{title}</h3>
            </header>
            <p className="flex-auto text-xs text-gray-600">{description}</p>
            <footer className="flex items-center justify-around gap-3 text-xs text-gray-500">
              <span>{icon1}</span>
              <span>{date}</span>
              <span>{time}</span>
              <span>{icon2}</span>
            </footer>
          </div>
        </div>
      ))}
    </div>
  );
};

export default CardTopicsList;
