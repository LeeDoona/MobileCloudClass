// Fill out your copyright notice in the Description page of Project Settings.

#include "PushPushBaby.h"
#include "LoadingActor.h"


// Sets default values
ALoadingActor::ALoadingActor()
{
 	// Set this actor to call Tick() every frame.  You can turn this off to improve performance if you don't need it.
	PrimaryActorTick.bCanEverTick = true;

	LoadingText = CreateDefaultSubobject<UTextRenderComponent>(TEXT("Genie"));
	LoadingText->SetHorizontalAlignment(EHTA_Center);
	LoadingText->SetWorldSize(200.0f);
	RootComponent = LoadingText;

	LoadingTime = 5;
}

// Called when the game starts or when spawned
void ALoadingActor::BeginPlay()
{
	Super::BeginPlay();
	
	LoadingDisplay();
	GetWorldTimerManager().SetTimer(LoadingHandle, this, &ALoadingActor::LoadingTimer, 1.0f, true);
}

// Called every frame
void ALoadingActor::Tick( float DeltaTime )
{
	Super::Tick( DeltaTime );

	FVector NewLocation = GetActorLocation();
	float DeltaHeight = (FMath::Sin(LoadingTime + DeltaTime) - FMath::Sin(LoadingTime));
	NewLocation.Z += DeltaHeight * 20.0f;
	LoadingTime += DeltaTime;
	SetActorLocation(NewLocation);
}

void ALoadingActor::LoadingDisplay()
{
	LoadingText->SetText(TEXT("Stack"));
}

void ALoadingActor::LoadingTimer()
{
	--LoadingTime;

	LoadingDisplay();

	if (LoadingTime < 1)
	{
		GetWorldTimerManager().ClearTimer(LoadingHandle);
		LoadingFinished();
	}
}

void ALoadingActor::LoadingFinished()
{
	UGameplayStatics::OpenLevel(GetWorld(), "StackStart");
}