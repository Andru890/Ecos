import image from "@/assets/image.webp";

const upcomingEventsList = [
  {
    id: 1,
    image: image,
    title: "EVENTO",
    supporting: "supporting text",
    date: "Published date",
    description:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
  },
  {
    id: 2,
    image: image,
    title: "EVENTO",
    supporting: "supporting text",
    date: "Published date",
    description:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
  },
  {
    id: 3,
    image: image,
    title: "EVENTO",
    supporting: "supporting text",
    date: "Published date",
    description:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
  },
];

const CardUpcomingEvents = () => {
  return (
    <div className="gap-4">
      {upcomingEventsList.map(({ id, image, title, supporting, date, description }) => (
        <div
          key={id}
          className="mb-6 flex h-auto w-full flex-col gap-6 rounded-lg bg-[#FEF7FF] px-4 py-2 sm:mx-auto sm:w-3/5"
        >
          <div className="flex gap-6 px-4 text-start">
            <img src={image} alt="image" className="h-48 w-48 rounded-xl" />
            <div className="flex flex-col gap-6">
              <header className="flex flex-col gap-1">
                <h3 className="text-2xl">{title}</h3>
                <p className="line-clamp-7 text-sm font-semibold whitespace-pre-line text-gray-600">
                  {supporting}
                </p>
              </header>
              <button type="submit" className="mt-4 w-24 rounded-[27px] bg-[#A0A0A0] px-4 py-2">
                Download
              </button>
            </div>
          </div>
          <footer className="flex flex-col gap-1 p-1">
            <p className="mx-4 text-xs text-[#49454F]">{date}</p>
            <p className="mx-auto line-clamp-7 px-4 text-lg whitespace-pre-line text-gray-600">
              {description}
            </p>
          </footer>
        </div>
      ))}
    </div>
  );
};

export default CardUpcomingEvents;
