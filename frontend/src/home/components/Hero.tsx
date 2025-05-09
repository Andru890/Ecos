export default function Hero() {
  return (
    <div className="flex h-auto w-full flex-col justify-start bg-[url('@/assets/imageBanner.webp')] bg-cover bg-center pb-48 sm:pb-64 lg:h-208">
      <div className="mx-12 mt-20 w-auto md:mx-24 lg:mx-36 lg:w-120">
        <h1 className="w-80 text-start font-sans text-[32px] leading-14 font-bold sm:w-138 sm:text-[42px] lg:w-112 lg:text-[48px]">
          Bienvenidos a Ecos tu plataforma musical ideal
        </h1>
        <p className="mt-4 w-80 text-start text-[14px] sm:w-128 lg:w-112 lg:text-[16px]">
          Descubre un mundo lleno de música y creatividad. Únete a nosotros para compartir tu arte y
          conectar con otros amantes de la música
        </p>
        <div className="mt-6 flex gap-12">
          <button type="submit" className="h-10 w-32 rounded-3xl bg-[#707070] text-sm text-white">
            Registrate
          </button>
          <button type="submit" className="h-10 w-32 rounded-3xl bg-[#B1B1B1] text-sm text-white">
            Explora
          </button>
        </div>
      </div>
    </div>
  );
}
